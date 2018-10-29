package com.hangsing.spout;

import java.util.List;
import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

/**
 * 
 *
 * 
 * @author hangsing
 *
 */
public class WsSpout extends BaseRichSpout {

	Map map;
	TopologyContext context;
	SpoutOutputCollector collector;
	int i = 0;


	@Override
	public void nextTuple() {

		i++;
		List tuple = new Values(i);
		this.collector.emit(tuple);
		System.err.println("spout -----------------------" + i);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void open(Map map, TopologyContext context, SpoutOutputCollector collector) {
		this.map = map;
		this.context = context;
		this.collector = collector;

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

		declarer.declare(new Fields("num"));

	}

}
