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
@Table(name="rack_master")
public class RackVO {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="rack")
	private String rack;
	
	
	@ManyToOne
	@JoinColumn(name="floorId")
	private FloorVO floorVO;
	
	@ManyToOne
	@JoinColumn(name="blockId")
	private BlockVO blockVO;
	
	@Column(name="status")
	private boolean status=true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public FloorVO getFloorVO() {
		return floorVO;
	}

	public void setFloorVO(FloorVO floorVO) {
		this.floorVO = floorVO;
	}

	public BlockVO getBlockVO() {
		return blockVO;
	}

	public void setBlockVO(BlockVO blockVO) {
		this.blockVO = blockVO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
