package com.es;

import com.es.util.BaseElasticService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author huangfeichang
 * @create 2020/2/6 20:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class EsTest {

    @Autowired
    private BaseElasticService baseElasticService;

    @Test
    public void test() {
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        baseElasticService.createIndex("twitter2",jsonString);
    }

    @Test
    public void indexIsExists() throws Exception {
        baseElasticService.isExistsIndex("twitter22");
    }

    @Test
    public void insert() {
        baseElasticService.insertOrUpdateOne("twitter2");
    }

    @Test
    public void search() {
        baseElasticService.search("twitter2");
    }

    @Test
    public void deleteIndex() {
        baseElasticService.deleteIndex("twitter2");
    }

    @Test
    public void deleteByQuery() {
        baseElasticService.deleteByQuery("twitter2", QueryBuilders.wildcardQuery("test", "*r*"));
    }
}
