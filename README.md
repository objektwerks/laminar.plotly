Laminar Plotly
--------------
>Laminar-Plotly app using ScalaJs and Scala 3.

Install
-------
1. brew install node
2. npm install npm-check-updates
3. npm install vite
>See **package.json**.

Update
------
1. ncu
2. ncu -u

Build
-----
1. npm install ( only when package.json changes )
2. sbt clean compile fastLinkJS copyFastOptMainJs
>See **target/public** directory.

Dev
---
>Edits are reflected in both sessions.
1. sbt ( new session )
2. ~ fastLinkJS copyFastOptMainJs
3. npm run dev ( new session )

Package
-------
1. sbt clean compile fullLinkJS copyFullOptMainJs
2. npm run build
>See **dist** directory.

Browser
-------
1. sbt clean compile fastLinkJS copyFastOptMainJs
2. npm run dev

Reference
---------
* [Laminar](https://laminar.dev/)
* [plotly-scala](https://github.com/alexarchambault/plotly-scala)
* [plotly.js](https://www.npmjs.com/package/plotly.js/v/1.47.4?activeTab=versions)
* [ScalaJs-Vite Tutorial](https://www.scala-js.org/doc/tutorial/scalajs-vite.html)