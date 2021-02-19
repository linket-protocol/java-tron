package org.tron.common.logsfilter.trigger;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.Setter;

public class ContractAllLogsTrigger extends Trigger {

  /**
   * unique id of this trigger. $tx_id + "_" + $index
   */
  @Getter
  @Setter
  private String uniqueId;

  @Getter
  @Setter
  private String logType;

  /**
   * id of the transaction which produce this event.
   */
  @Getter
  @Setter
  private String transactionId;

  /**
   * address of the contract triggered by the callerAddress.
   */
  @Getter
  @Setter
  private String contractAddress;

  /**
   * caller of the transaction which produce this event.
   */
  @Getter
  @Setter
  private String callerAddress;

  /**
   * origin address of the contract which produce this event.
   */
  @Getter
  @Setter
  private String originAddress;

  /**
   * caller address of the contract which produce this event.
   */
  @Getter
  @Setter
  private String creatorAddress;

  /**
   * block number of the transaction
   */
  @Getter
  @Setter
  private Long blockNumber;

  /**
   * true if the transaction has been revoked
   */
  @Getter
  @Setter
  private boolean removed;

  @Getter
  @Setter
  private long latestSolidifiedBlockNumber;


  /**
   * decode from sha3($EventSignature) with the ABI of this contract.
   */
  @Getter
  @Setter
  private String eventSignature;

  @Getter
  @Setter
  private String eventSignatureFull;

  @Getter
  @Setter
  private String eventName;

  /**
   * decode from topicList with the ABI of this contract. this item is null if not called
   * ContractEventParserAbi::parseTopics(ContractEventTrigger trigger)
   */
  @Getter
  @Setter
  private Map<String, String> topicMap;

  /**
   * multi data items will be concat into a single string. this item is null if not called
   * ContractEventParserAbi::parseData(ContractEventTrigger trigger)
   */
  @Getter
  @Setter
  private Map<String, String> dataMap;


  public ContractAllLogsTrigger() {
    super();
    setTriggerName(Trigger.CONTRACT_ALL_LOGS_TRIGGER_NAME);
  }

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
    this.topicMap = IntStream.range(0, topicList.size()).boxed().collect(Collectors
        .toMap(String::valueOf, i -> topicList.get(i), (a, b) -> b, Maps::newHashMap));
    HashMap<String, String> data = Maps.newHashMap();
    data.put("0", contractLogTrigger.getData());
    this.dataMap = data;
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
    this.topicMap = contractEventTrigger.getTopicMap();
    this.dataMap = contractEventTrigger.getDataMap();
    this.logType = LogType.LOG.str;
    setTriggerName(Trigger.CONTRACT_ALL_LOGS_TRIGGER_NAME);

  }

  enum LogType {
    LOG("log"),
    EVENT("evnet");
    String str;

    LogType(String str) {
      this.str = str;
    }
  }
}
