package com.hangsing.test;

import com.hangsing.bolt.WsBolt;
import com.hangsing.spout.WsSpout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;


public class Test {

    public static void main(String[] args) {
        TopologyBuilder tb = new TopologyBuilder();

        tb.setSpout("wsspout", new WsSpout());
        tb.setBolt("wsbolt", new WsBolt()).shuffleGrouping("wsspout");


        LocalCluster lc = new LocalCluster();
        lc.submitTopology("ws", new Config(), tb.createTopology());
    }

}
