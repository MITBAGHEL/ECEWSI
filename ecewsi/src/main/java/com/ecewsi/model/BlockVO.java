package com.ecewsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="block_master")
public class BlockVO {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="floorId")
	private FloorVO floorVO;
	
	@Column(name="block")
	private String block;
	
	@Column(name="blockDiscription")
	private String blockDiscription;
	
	@Column(name="status")
	private boolean status  =true;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FloorVO getFloorVO() {
		return floorVO;
	}

	public void setFloorVO(FloorVO floorVO) {
		this.floorVO = floorVO;
	}

	

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getBlockDiscription() {
		return blockDiscription;
	}

	public void setBlockDiscription(String blockDiscription) {
		this.blockDiscription = blockDiscription;
	}



}
