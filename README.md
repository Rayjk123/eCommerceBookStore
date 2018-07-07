# eCommerceBookStore
An eCommerce Book Store Website for a UGA assignment. Currently meant to be used with Tomcat 9.0 servers and Eclipse.

## User Stories:
[User Stories Board](https://ugacsci4050.myjetbrains.com/youtrack/agiles)

## Installation
### Required Technologies
Eclipse for Java EE Developers or add in the Java EE portion
* [Eclipse for Java EE Developers](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/photonr)
Apache Tomcat Download
* [Apache Tomcat 9.0](https://tomcat.apache.org/download-90.cgi)
* [Adding Tomcat to Eclipse:](https://stackoverflow.com/questions/8046871/how-to-add-tomcat-server-in-eclipse)

#### Validate Java EE Installed
You can validate if you have Java EE by going to File -> New -> Other and search for Dynamic Web Project<br>
If you don't have Java EE installed, ask Seth for more info because managed to install just the plugin. It should be in the Eclipse Marketplace under the name Maven Java EE for Luna or something similar.

### How to Import Project into Eclipse
1. Git clone repo into your eclipse workspace
2. File -> Open Projects from File System
3. Click Directory
4. Find repo directory and click ok
5. Add src package to Java Resources if red ! appears

**In case of Java Objects being Invalid**<br>
1. Right Click Projects and go to Properties -> Java Build Path
2. Click the Libraries Tab
3. Remove JRE System Library
4. Select Class Path
5. Click Add Library -> JRE System Library -> Next -> Workspace Default JRE
6. Apply the changes


## Running
Currently there is only an index homepage which can be run by going to index.html under the WebContent directory and clicking the green run button.

## Where to Find Images:
Images are stored remotely and grabbed remotely from an Amazon S3 bucket. This is done in order to remove a large amount of bulk from the project itself. The bucket is: 
* [Amazon S3 Image Bucket](https://s3.console.aws.amazon.com/s3/buckets/csci4050/?region=us-east-2&tab=overview)
* Need an AWS account to view bucket. It's free and you can use any email.
