(defn label
  "Widget for displaying a single line of text."
  [s]
  (str "grid [label .myLabel -text "
       s " -textvariable labelText]\n"))

(defn text
  "Widget for displaying and optionally edit multiple lines of text."
  [s w h]
  (str "grid [text .myText -width "
       w " -height " h "]
.myText insert 1.0 " s "\n"))

(defn entry
  "Widget used to accept a single line of text as input."
  [s]
  (str "grid [entry .myEntry -text " s "]\n"))

(defn msg
  "Widget for displaying multiple lines of text."
  [bg fg s]
  (str "grid [message .myMessage -background " bg
       " -foreground " fg " -text " s "]\n"))

(defn button
  "Widget that is clickable and triggers an action."
  [s f]
  (str "grid [button .myButton1  -text " s
       " -command " f "]\n"))

(defn top-level
  "Widget that creates a frame that is a new top level window."
  [w h bg border padx pady]
  (str "toplevel .top -width " w " -height " h
" -background " bg " -relief ridge -borderwidth " border
" -padx " padx " -pady " pady))

(let [top-bar (label "Babashka-Tk")
      window (text "Year-of-the\\nBabashka-Desktop"
                   20 5)
      entry (entry "Entry")
      message (msg "orange" "purple" "Message\\nwidget")
      button (button "Click-me!" "\"set labelText clicked\"")]
  (spit "widget" (str "#!/usr/bin/wish\n"
                      top-bar window entry message button))
  (shell/sh "chmod" "+x" "./widget")
  (shell/sh "./widget"))
