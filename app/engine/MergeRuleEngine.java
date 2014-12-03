package engine;

import engine.models.ResourceListWrapper;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.ClassObjectFilter;
import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.stereotype.Component;
import resources.CustomerResource;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: gmatsu
 */
@Component
public class MergeRuleEngine {

  KnowledgeBuilder mergeKnowledgeBuilder;

  @PostConstruct
  public void init(){
    KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    kbuilder.add(ResourceFactory.newClassPathResource("rules/CustomerMerge.drl"), ResourceType.DRL);
    mergeKnowledgeBuilder = kbuilder;
  }

  //merge 2 customers
  public CustomerResource merge(List<CustomerResource> customers){

    ResourceListWrapper wrapper = new ResourceListWrapper();
    wrapper.resourceList = new ArrayList<>(customers);

    StatelessKnowledgeSession ksession = null;

    try {
      synchronized (mergeKnowledgeBuilder) {
        ksession = mergeKnowledgeBuilder.newKnowledgeBase().newStatelessKnowledgeSession();
      }

      ksession.execute(wrapper);

      //TODO: extract final merged Resource out

    }catch(Exception e){

    }

    return null;
  }


}
