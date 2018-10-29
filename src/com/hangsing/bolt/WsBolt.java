package com.hangsing.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class WsBolt extends BaseRichBolt {

	Map stormConf;
	TopologyContext context;
	OutputCollector collector;
	int sum = 0;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

		this.stormConf = stormConf;
		this.context = context;
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {

		int i = input.getIntegerByField("num");

		sum += i;
		
		System.out.println("sum-------------------------------"+sum);
		

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
