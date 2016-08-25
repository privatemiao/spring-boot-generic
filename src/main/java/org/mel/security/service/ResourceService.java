package org.mel.security.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.mel.framework.domain.ResourceType;
import org.mel.framework.util.BeanMapper;
import org.mel.security.domain.Menu;
import org.mel.security.domain.Node;
import org.mel.security.entity.SecurityRight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ResourceService {
	protected Logger logger = LoggerFactory.getLogger(ResourceService.class);
	// 所有节点
	private List<Node> nodes = null;
	private Map<String, Node> nodeIndex = new HashMap<>();
	private Map<String, Node> exceptedNodes = new HashMap<>();
	
	@Resource
	private SecurityRightService securityRightService;

	@PostConstruct
	protected void init() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Menu menu = mapper.readValue(this.getClass().getClassLoader().getResourceAsStream("resources.json"), Menu.class);
		this.nodes = menu.getNodes();
		indexNodes(this.nodes, null);
		printNodes(nodeIndex);
		printNodes(exceptedNodes);
		mergeToDB();
	}

	public List<Node> getAllMenus() {
		return this.nodes;
	}

	private void printNodes(Map<String, Node> map) {
		System.out.println("=====================================");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " - " + map.get(key));
		}
	}

	private void indexNodes(List<Node> nodes, String parentUri) {
		int sequence = 1;
		for (Node node : nodes) {
			node.setSequence(sequence++);
			node.setParentUri(parentUri == null ? node.getUri() : parentUri);
			if (node.isExcepted()) {
				exceptedNodes.put(node.getUri(), node);
			} else {
				nodeIndex.put(node.getUri(), node);
			}
			if (node.getNodes().size() > 0) {
				indexNodes(node.getNodes(), node.getUri());
			}
		}
	}

	private void mergeToDB() {
		System.out.println("====================mergeToDB========================");
		List<SecurityRight> rights = new ArrayList<>();
		Set<String> keys = nodeIndex.keySet();
		for (String key : keys) {
			Node node = nodeIndex.get(key);
			if (node.getType() == ResourceType.BUTTON || node.getType() == ResourceType.OPERATE){
				SecurityRight right = BeanMapper.map(node, SecurityRight.class);
				rights.add(right);
			}
		}

		securityRightService.syncRights(rights);
	}

}
