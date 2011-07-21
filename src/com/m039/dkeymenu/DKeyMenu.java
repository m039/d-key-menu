package com.m039.dkeymenu;

import java.util.List;
import java.util.ArrayList;

/**
 * Describe class Menu here.
 *
 *
 * Created: Sat Jun 18 14:58:35 2011
 *
 * @author <a href="mailto:flam44@gmail.com">Mozgin Dmitry</a>
 * @version 1.0
 */
abstract public class DKeyMenu
    implements DHelpMsg {

    static private final int		DEFAULT = 0;

    private List<DKeyMenu>		mDKeyMenus;
    private final int			mMainKey;
    private boolean			mInMenu;		

    protected DKeyMenu() {
	this(DEFAULT);
    }
    
    protected DKeyMenu(int key) {
	mDKeyMenus = new ArrayList<DKeyMenu>();
	mMainKey  = key;

	if (key == DEFAULT) {
	    mInMenu = true;
	} else {
	    mInMenu = false;
	}
    }
    
    public void			keyDown(int key) {
	if ((key == mMainKey) && !mInMenu) {
	    mInMenu = true;
	    enterMenu();
	    return;
	} else if ((key == mMainKey) && mInMenu) {
	    mInMenu = false;
	    exitMenu();
	    return;
	}

	if (!mInMenu) {
	    return;
	}

	for (DKeyMenu m: mDKeyMenus) {
	    if (m.mInMenu) {
		m.keyDown(key);
		return;
	    }
	}

	for (DKeyMenu m: mDKeyMenus) {
	    if (m.mMainKey == key) {
		m.keyDown(key);
		return;
	    }
	}

	doMenuItem(key);
    }

    public void			addMenu(DKeyMenu kmenu) {
	mDKeyMenus.add(kmenu);
    }

    // implementation of the HelpMessage

    public String	getHelpMsg() {
	StringBuilder sb = new StringBuilder();
	
	for (DKeyMenu m: mDKeyMenus) {
	    sb.append(prettify(m.getHelpMsg()));
	}

	return sb.toString();
    }

    private String	prettify(String str) {
	String list[]    = str.split("\n");
	StringBuilder sb = new StringBuilder();

	for (String s: list) {
	    sb.append("  " + s + "\n");
	}

	if (mMainKey == DEFAULT) {
	    return str;
	} else {
	    return sb.toString();
	}
    }

    // methods to implement
    
    abstract public void	enterMenu();
    abstract public void	exitMenu();
    abstract public void	doMenuItem(int key);

}
