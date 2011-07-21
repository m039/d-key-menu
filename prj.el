(jde-project-file-version "1.0")
(jde-set-variables
 '(browse-url-browser-function 'browse-url-generic)
 '(browse-url-generic-program "/usr/bin/conkeror")
 '(jde-compile-enable-kill-buffer nil)
 '(jde-ant-enable-find t)
 ;; '(jde-electric-return-p t)
 '(jde-ant-complete-target t)
 '(jde-enable-abbrev-mode nil)
 '(jde-global-classpath '("./bin/classes"
			  "./src"
			  "./lib/AppleJavaExtensions.jar"
			  "./lib/jinput.jar"
			  "./lib/lwjgl.jar"
			  "./lib/lwjgl-debug.jar"
			  "./lib/lwjgl_test.jar"
			  "./lib/lwjgl_util_applet.jar"
			  "./lib/lwjgl_util.jar"
			  "./lib/lzma.jar"
			  ))
 '(jde-run-working-directory "./")
 '(jde-ant-read-target t)
 '(jde-jdk-doc-url "http://developer.android.com/guide/topics/fundamentals.html")
 '(jde-compile-option-directory "./bin/classes")
 '(jde-complete-function (quote jde-complete-menu))
 '(jde-sourcepath '("./src"
		    ))
 ;; '(jde-help-use-frames nil)
 '(jde-complete-insert-method-signature nil)
 '(jde-help-docsets (quote (("JDK API" "http://java.sun.com/javase/6/docs/api" nil)
			    ))))

;; (visit-tags-table "./TAGS")