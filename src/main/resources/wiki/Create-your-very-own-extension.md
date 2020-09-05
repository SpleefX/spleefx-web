This page will cover how to create an extension. [Don't know what an extension is?](Understand-extensions)

>**Page Index**:
> 1. [Prerequisites](Create-your-very-own-extension#prerequisites)
> 2. [Add your extension](Create-your-very-own-extension#add-your-extension)
---

# Prerequisites
* Text editor skills
* *(Optional, but recommended)* A JSON parser. A recommended one is [https://jsonformatter.org/json-parser](https://jsonformatter.org/json-parser).
* The extension template. [An example one can be found here.](https://github.com/SpleefX/SpleefX/blob/master/core/src/main/resources/extensions/custom/-example-mode.json)
* Brainies (eh???)

# Add your extension

 1. Create a JSON file with your extension key. For example, if we were to use `sumo` as an extension name, the file name would be `sumo.json`
 2. Edit your extension. Make sure it follows the [basic template](https://github.com/SpleefX/SpleefX/blob/master/core/src/main/resources/extensions/custom/-example-mode.json)!
 3. Paste the extension text inside your JSON file, and save it.
 4. Load your extension, by either:
    * Restarting your server
    * Commands, as in: **/spleefx extension load <extension key>**.