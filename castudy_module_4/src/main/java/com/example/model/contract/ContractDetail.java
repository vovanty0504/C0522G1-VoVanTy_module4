package com.example.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractDetailId;
    private int contractDetailQuantity;

    @ManyToOne
    @JoinColumn(name = "contract_id" ,referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id",referencedColumnName = "attachFacilityId")
    private AttachFacility attachFacility;


    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, int contractDetailQuantity, Contract contract,
                          AttachFacility attachFacility) {
        this.contractDetailId = contractDetailId;
        this.contractDetailQuantity = contractDetailQuantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getContractDetailQuantity() {
        return contractDetailQuantity;
    }

    public void setContractDetailQuantity(int contractDetailQuantity) {
        this.contractDetailQuantity = contractDetailQuantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
