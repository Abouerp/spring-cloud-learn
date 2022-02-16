package com.abouerp.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Abouerp
 */
@Configuration
public class MySelfRule {
    /*负载均衡更换方法   两个shift   查询IRule   然后ctrl+H   显示IRule接口下所有实现方法（有七种方法）
       Ribbon的IRule官方文档明确给出警告：这个自定义配置类不能放在@ComponentScan所扫描的当前包以及子包下
       启动类中包含@SpringBootApplication的注解中就包含@ComponentScan这个注解，所以我们需要新建另一个一个包来设置这个配置类
       否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了

       这个Bean生效的到启动类添加@RibbonClient这个注解
    * */
    @Bean
    public IRule myRule(){
        //采用随机算法，
        return new RandomRule();
    }
}
