hbase-java-sample
=========

A sample program for connecting a remote HBase in Java.

*Don't forget to enable assert!* 
It can be enabled as follows in eclipse:
Window > Preferences > Java > Installed JREs > Edit > Default VM Arguments: -ea

Author
------

(c) Yuji Kosuga 2012    
<http://blog.yujikosuga.com>  
<yujikosuga43@gmail.com>

License 
-------

hbase-java-sample is freely distributable under [the MIT license](http://www.opensource.org/licenses/mit-license.php).  

Usage
-----

java Main *(with no arguments)*
    
    Launch this program with hbase-default.xml.

java Main [config_file]

    Lauch this program with the pecified config file, which is a usually a copy of hbase-site.xml.
    A sample hbase-site.xml is in the conf directory.

java Main [hbase.zookeeper.quorum] [hbase.zookeeper.property.clientPort]

    Lauch this program with the specified zookeeper parameters.
    [hbase.zookeeper.quorum] is a comma separated list of servers in the ZooKeeper Quorum, for which \"localhost\" is set in the Zookeeper default configuration.
    [hbase.zookeeper.property.clientPort] is the port at which the clients will connect, for which \"2181\" is set in the Zookeeper default configuration.

