package org.mel.security.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.domain.ResourceType;

public class Node {
	private String uri;
	private String name;
	private String css;
	private boolean excepted = false;
	private ResourceType type;
	private List<Node> nodes = new ArrayList<>();
	private String parentUri;
	private int sequence;

	public Node() {
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public boolean isExcepted() {
		return excepted;
	}

	public void setExcepted(boolean excepted) {
		this.excepted = excepted;
	}

	public String getParentUri() {
		return parentUri;
	}

	public void setParentUri(String parentUri) {
		this.parentUri = parentUri;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
