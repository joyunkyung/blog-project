package com.post.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.post.blog.config.auth.PrincipalDetailService;

import lombok.RequiredArgsConstructor;

//스프링 시큐리티에서는 3개의 어노테이션 걸어줘야함
@Configuration // 빈등록 (IoC관리): 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@EnableWebSecurity // 시큐리티 필터가 등록 
//Controller에서 특정 권한이 있는 유저만 접근을 허용하려면 @PreAuthorize 어노테이션을 사용하는데, 해당 어노테이션을 활성화 시키는 어노테이션이다.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근시 권한 및 인증을 미리 체크함
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final  PrincipalDetailService principalDetailService;
	private final  AuthenticationFailureHandler LoginFailHandler;
		
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean // IoC
	//회원가입시 비밀번호 해쉬 암호화
	public BCryptPasswordEncoder encodePWD() {
		//BCryptPasswordEncoder: 시큐리티가 가지고있는 함수
		return new BCryptPasswordEncoder();//스프링이 관리(IoC)
	}
	
	// 시큐리티가 대신 로그인해주는데(Principaldetail.java,PrincipaldetailService.java) 
	// password를 가로채기 후 해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
	// 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	//시큐리티 필터
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()  // csrf 토큰 비활성화 (테스트시 걸어두는 게 좋음),자바스크립트(ajax)를 통한 요청에서는 csrf토큰이 없기때문
			.authorizeRequests() //요청이 들어오면
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**", "/dummy/**") //해당 주소들은 인증없이 누구나 접근 가능
				.permitAll()
				.anyRequest()
				.authenticated()
				//이것이 아닌 다른 모든 요청은 인증 필요
			.and()
				.formLogin()
				.loginPage("/auth/loginForm") //로그인 페이지를 내가만든페이지로 연결
				.loginProcessingUrl("/auth/loginProc")// 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
				.failureHandler(LoginFailHandler)  //로그인 실패시 
				.defaultSuccessUrl("/"); //로그인 성공하면 해당 주소(메인)으로 이동
		//->인증이 되지않은 요청은 모두 "/auth/loginForm"(로그인페이지)로 연결 됨 
	}
}




