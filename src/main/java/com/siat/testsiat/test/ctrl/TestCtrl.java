package com.siat.testsiat.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siat.testsiat.test.service.TestService;


/*
IOC(Inversion of Control) : 제어의 역행
-DI(Dependency Injection) : 의존성 주입
-DL(Dependency Lookup) : 의존성 조회
객체 생성과 관련된 Annotation
    * @Component : 객체를 생성하는 Annotation
    * @Controller : @Component의 특수화된 형태로, Controller를 생성하는 Annotation
    * @RestController : @Controller와 @ResponseBody를 합친 Annotation
    * @Service : @Component의 특수화된 형태로, Service를 생성하는 Annotation
    * @Repository : @Component의 특수화된 형태로, Repository를 생성하는 Annotation 
사용자 요청과 관련된 Annotation
    * @RequestMapping : 요청 URL과 메서드를 매핑하는 Annotation
    * @GetMapping : GET 요청을 처리하는 Annotation
    * @PostMapping : POST 요청을 처리하는 Annotation
    * @PutMapping : PUT 요청을 처리하는 Annotation
    * @DeleteMapping : DELETE 요청을 처리하는 Annotation
    * @PatchMapping : PATCH 요청을 처리하는 Annotation
    * @RequestParam : 요청 파라미터를 처리하는 Annotation
    * @RequestBody : 요청 본문을 처리하는 Annotation
    * @ResponseBody : 응답 본문을 처리하는 Annotation
의존성 관리를 위한 Annotation
    * @Autowired : 의존성 주입을 위한 Annotation
    * @Qualifier : 의존성 주입을 위한 Annotation
    * @Value : 의존성 주입을 위한 Annotation
    * @Configuration : 설정 클래스를 생성하는 Annotation
    * @Bean : Bean을 생성하는 Annotation
    * @PropertySource : 프로퍼티 파일을 읽어오는 Annotation
    * @ComponentScan : 컴포넌트를 스캔하는 Annotation
    * @EnableAspectJAutoProxy : AOP를 활성화하는 Annotation
    * @Resource : 의존성 주입을 위한 Annotation
    * @Inject : 의존성 주입을 위한 Annotation
 */

@Controller
@RequestMapping("/test")
public class TestCtrl {
    @Autowired
    private TestService service;

    @RequestMapping("/insert")
    public String insert(){
        System.out.println("ctrl insert");
        System.out.println("ctrl inject: " + service);
        //service.TestService();
        return "insert";
    }
    @RequestMapping("/update")
    public String update(){
        System.out.println("ctrl update");
        return "update";
    }
    @RequestMapping("/delete")
    public String delete(){
        System.out.println("ctrl delete");
        return "delete";
    }
    @RequestMapping("/select")
    public String select(){
        System.out.println("ctrl select");
        return "select";
    }
}
