package org.tron.common.logsfilter.trigger;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.Setter;
import org.tron.common.logsfilter.capsule.RawData;

public class ContractAllLogsTrigger extends ContractBasicTrigger {

  enum LogType {
    LOG("log"),
    EVENT("event");
    String str;

    LogType(String str) {
      this.str = str;
    }
  }

  @Getter
  @Setter
  @JSONField(name = "type")
  private String logType;

  /**
   * decode from sha3($EventSignature) with the ABI of this contract.
   */
  @Getter
  @Setter
  @JSONField(name = "sign")
  private String eventSignature;

  @Getter
  @Setter
  @JSONField(name = "sign_full")
  private String eventSignatureFull;

  @Getter
  @Setter
  @JSONField(name = "event")
  private String eventName;

  @Getter
  @Setter
  private RawData rawData;

//  /**
//   * decode from topicList with the ABI of this contract. this item is null if not called
//   * ContractEventParserAbi::parseTopics(ContractEventTrigger trigger)
//   */
//  @Getter
//  @Setter
//  private Map<String, String> topicMap;
//
//  /**
//   * multi data items will be concat into a single string. this item is null if not called
//   * ContractEventParserAbi::parseData(ContractEventTrigger trigger)
//   */
//  @Getter
//  @Setter
//  private Map<String, String> dataMap;

  public ContractAllLogsTrigger(ContractLogTrigger contractLogTrigger) {
    this.timeStamp = contractLogTrigger.timeStamp;
    this.uniqueId = contractLogTrigger.getUniqueId();
    this.transactionId = contractLogTrigger.getTransactionId();
    this.contractAddress = contractLogTrigger.getContractAddress();
    this.callerAddress = contractLogTrigger.getCallerAddress();
    this.originAddress = contractLogTrigger.getOriginAddress();
    this.creatorAddress = contractLogTrigger.getCreatorAddress();
    this.blockNumber = contractLogTrigger.getBlockNumber();
    this.removed = contractLogTrigger.isRemoved();
    this.latestSolidifiedBlockNumber = contractLogTrigger.getLatestSolidifiedBlockNumber();
    this.eventSignature = contractLogTrigger.getTriggerName();
    this.eventSignatureFull = contractLogTrigger.getTriggerName();
    this.eventName = contractLogTrigger.getTriggerName();
    List<String> topicList = contractLogTrigger.getTopicList();
    this.rawData = contractLogTrigger.getRawData();
//    this.topicMap = IntStream.range(0, topicList.size()).boxed().collect(Collectors
//        .toMap(String::valueOf, i -> topicList.get(i), (a, b) -> b, Maps::newHashMap));
//    HashMap<String, String> data = Maps.newHashMap();
//    data.put("0", contractLogTrigger.getData());
//    this.dataMap = data;
    this.logType = LogType.LOG.str;
    setTriggerName(Trigger.CONTRACT_ALL_LOGS_TRIGGER_NAME);

  }

  public ContractAllLogsTrigger(ContractEventTrigger contractEventTrigger) {
    this.timeStamp = contractEventTrigger.timeStamp;
    this.uniqueId = contractEventTrigger.getUniqueId();
    this.transactionId = contractEventTrigger.getTransactionId();
    this.contractAddress = contractEventTrigger.getContractAddress();
    this.callerAddress = contractEventTrigger.getCallerAddress();
    this.originAddress = contractEventTrigger.getOriginAddress();
    this.creatorAddress = contractEventTrigger.getCreatorAddress();
    this.blockNumber = contractEventTrigger.getBlockNumber();
    this.removed = contractEventTrigger.isRemoved();
    this.latestSolidifiedBlockNumber = contractEventTrigger.getLatestSolidifiedBlockNumber();
    this.eventSignature = contractEventTrigger.getEventSignature();
    this.eventSignatureFull = contractEventTrigger.getEventSignatureFull();
    this.eventName = contractEventTrigger.getEventName();
    this.rawData = contractEventTrigger.getRawData();
//    this.topicMap = contractEventTrigger.getTopicMap();
//    this.dataMap = contractEventTrigger.getDataMap();
    this.logType = LogType.EVENT.str;
    setTriggerName(Trigger.CONTRACT_ALL_LOGS_TRIGGER_NAME);

  }
}
