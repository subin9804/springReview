package org.koreait.exam01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan(value="org.koreait", excludeFilters=@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={MemberDao.class}))	
//@ComponentScan(value="org.koreait", excludeFilters=@Filter(type=FilterType.ANNOTATION, classes={MenualBean.class})) // MenualBean이 붙은 클래스 제외
//@ComponentScan(value="org.koreait", excludeFilters=@Filter(type=FilterType.ASPECTJ, pattern=".rg.koreait..*.*Dao"))	// Dao로 끝나는 모든 클래스 제외
@ComponentScan("org.koreait")
public class AppCtx {

}
