
package com.yujikosuga.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class Main {

    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();

        switch (args.length) {
            case 0:
                break;
            case 1:
                config.addResource(new Path(args[0]));
                break;
            case 2:
                config.set("hbase.zookeeper.quorum", args[0]);
                config.set("hbase.zookeeper.property.clientPort", args[1]);
                break;
            default:
                p("Usage:");
                p("\tjava Main");
                p("\t\tLaunch this program with hbase-default.xml.");

                p("\tjava Main [config_file]");
                p("\t\tLauch this program with the pecified config file, which is a usually a copy of hbase-site.xml.");
                p("\t\tA sample hbase-site.xml is in the conf directory.");

                p("\tjava Main [hbase.zookeeper.quorum] [hbase.zookeeper.property.clientPort]");
                p("\t\tLauch this program with the specified zookeeper parameters.");
                p("\t\t[hbase.zookeeper.quorum] is a comma separated list of servers in the ZooKeeper Quorum, for which \"localhost\" is set in the Zookeeper default configuration.");
                p("\t\t[hbase.zookeeper.property.clientPort] is the port at which the clients will connect, for which \"2181\" is set in the Zookeeper default configuration.");

                System.exit(1);
                break;
        }

        try {
            HBaseAdmin.checkHBaseAvailable(config);
        } catch (MasterNotRunningException e) {
            p("HBase is not running.");
            System.exit(1);
        }

        Sample sample = new Sample();
        sample.run(config);
    }

    private static void p(String msg) {
        System.out.println(msg);
    }
}
