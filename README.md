# Application_Framework_Suite
A suite of frameworks needed for developing software projects of any type.

Eclipse IDE Note for org.w3c.dom.Node Compilation Error In fw_web project
=================================================================================
If you recognize the compilation error, "The method getTextContent() is undefined for the type Node", regarding class org.w3c.dom.Node, it can be resolved by navigating to project properties | Java Build Path | Order and Export tab, selected the JRE (which was at the bottom of the list) and clicked the "Top" button to move it to the top (or at least above the Maven Dependencies).   Go here for further explanation:  https://stackoverflow.com/questions/5534864/compilation-error-in-node-gettextcontent-for-jdk-6


Ensure that the the following directories are created and populated as exected:
1.  /tmp (for testing)
2.  /AppServer (look in the project, web_server_configuration, under the location, src/main/resources/examples/web-server-setup/config-directory-structure, for sub-directories to include)
