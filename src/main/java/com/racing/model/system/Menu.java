package com.racing.model.system;

import com.racing.mybatis.mapper.BaseEntity;
import com.racing.sql.DBField;
import com.racing.sql.DBIndex;
import com.racing.sql.DBTable;

@DBTable(remark = "系统菜单")
public class Menu extends BaseEntity {
	@DBIndex
	@DBField(type = "NUMBER", length = 10, remark = "ID")
	private Integer id;
	@DBField(length = 30, remark = "菜单名称")
	private String name;
	@DBField(length = 50, remark = "菜单URL")
	private String url;
	@DBField(type = "NUMBER", length = 10, remark = "序号")
	private Integer seq;
	@DBField(type = "NUMBER", length = 10, remark = "级别")
	private Integer levl;
	@DBField(type = "NUMBER", length = 10, remark = "父节点")
	private Integer parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getLevl() {
		return levl;
	}

	public void setLevl(Integer levl) {
		this.levl = levl;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}
}