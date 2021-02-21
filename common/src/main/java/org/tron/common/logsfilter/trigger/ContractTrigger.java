package org.tron.common.logsfilter.trigger;

import lombok.Getter;
import lombok.Setter;
import org.tron.common.logsfilter.capsule.RawData;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;

public class ContractTrigger extends ContractBasicTrigger {



  @Getter
  @Setter
  private LogInfo logInfo;


  @Getter
  @Setter
  private ABI abi;
}
