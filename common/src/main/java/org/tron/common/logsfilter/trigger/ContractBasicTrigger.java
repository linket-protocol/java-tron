package org.tron.common.logsfilter.trigger;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.tron.common.logsfilter.capsule.RawData;

public class ContractBasicTrigger extends Trigger {
  /**
   * unique id of this trigger. $tx_id + "_" + $index
   */
  @Getter
  @Setter
  @JSONField(name = "uid")
  protected String uniqueId;

  /**
   * id of the transaction which produce this event.
   */
  @Getter
  @Setter
  @JSONField(name = "tid")
  protected String transactionId;

  /**
   * address of the contract triggered by the callerAddress.
   */
  @Getter
  @Setter
  @JSONField(name = "contract")
  protected String contractAddress;

  /**
   * caller of the transaction which produce this event.
   */
  @Getter
  @Setter
  @JSONField(name = "caller")
  protected String callerAddress;

  /**
   * origin address of the contract which produce this event.
   */
  @Getter
  @Setter
  @JSONField(name = "origin")
  protected String originAddress;

  /**
   * caller address of the contract which produce this event.
   */
  @Getter
  @Setter
  @JSONField(name = "creator")
  protected String creatorAddress;

  /**
   * block number of the transaction
   */
  @Getter
  @Setter
  @JSONField(name = "block")
  protected Long blockNumber;

  /**
   * true if the transaction has been revoked
   */
  @Getter
  @Setter
  protected boolean removed;

  @Getter
  @Setter
  @JSONField(name = "s_block")
  protected long latestSolidifiedBlockNumber;


  @Getter
  @Setter
  @JSONField(name = "raw")
  protected RawData rawData;
}
