package com.m039.dkeymenu;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;

public class DKeyMenuExample {

    private class TestMenu extends DKeyMenu
        implements DHelpMsg {

        private final String mJustForComments;

        public TestMenu(int key, String justForComments) {
            super(key);
            mJustForComments = justForComments;
        }

        @Override
        public void		doMenuItem(int key) {
            switch (key) {
            case Keyboard.KEY_1:
                System.out.println("ONE");
            break;
            case  Keyboard.KEY_2:
                System.out.println("TWO");
                break;
            }
        }

        @Override
        public void		enterMenu() {
            System.out.println(mJustForComments + ": Enter into test menu.");
        }

        @Override
        public void		exitMenu() {
            System.out.println(mJustForComments + ": Exit test menu.");
        }

        // Implementation of m039.game.debug.HelpMessage

        public final String getHelpMsg() {
            String msg = mJustForComments + " menu:\n";

            msg += "  <1> prints ONE\n";
            msg += "  <2> prints TWO\n";

            return msg + super.getHelpMsg();
        }
    }

    private class MagicKeys extends DKeyMenuAdapter {
        MagicKeys() {
            super();
            addMenu(new TestMenu(Keyboard.KEY_A, "AKey"));
            addMenu(new TestMenu(Keyboard.KEY_B, "BKey"));
        }

        @Override
        public void	doMenuItem(int key) {
            switch (key) {
            case Keyboard.KEY_1:
                System.out.println("ONE");
            break;
            case Keyboard.KEY_2:
                System.out.println("TWO");
                break;
            case Keyboard.KEY_H:
                showHelp();
		break;
            case Keyboard.KEY_Q:
                System.exit(0);
                break;
            }
        }

        // private methods

        private void	showHelp() {
            StringBuilder sb = new StringBuilder();

            sb.append("MagicKeys's help:\n");
            sb.append("  <H> print this message\n");
            sb.append("  <A> go to AKey menu\n");
            sb.append("  <B> go to BKey menu\n");
            sb.append("  <Q> exit\n");	    
            sb.append(super.getHelpMsg());

            System.out.print(sb);
        }
    }

    private MagicKeys mMagicKeys = new MagicKeys();

    public void start() {
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        while (!Display.isCloseRequested()) {

            // Here the usage of the DKeyMenu
            while (Keyboard.next()) {
                if (Keyboard.getEventKeyState()) {
                    mMagicKeys.keyDown(Keyboard.getEventKey());
                }
            }

            Display.update();
        }

        Display.destroy();
    }

    public static void main(String[] argv) {
        DKeyMenuExample e = new DKeyMenuExample();
        e.start();
    }
}