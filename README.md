# 스프링 부트와 AWS 로 혼자 구현하는 웹 서비스

## 배운 내용

### 6월 23일
- grable.build
    - 해당 파일로 프로젝트의 플러그인 의존성 관리를 할 수 있다.
- ext
    - grable.build 에서 사용하는 전역변수를 설정한다는 의미이다.
- grable buildscript 란?
    > [grable buildscript1](http://www.devkuma.com/books/pages/1086)<br/>
      [grable buildscript2](https://jahyun-dev.github.io/posts/gradle-1/)
    - **이 buildscript라는 것은 빌드 스크립트를 위한 것이다. 빌드 스크립트라는 것은 그 이름대로 빌드를 위해 실행되는 스크립트이다.
     Gradle에 있는 기능 그대로 빌드를 할 경우에는 이 buildscript이 필요없다. 이것은 빌드할 때 외부 라이브러리 등을 사용하는 경우에 필요하다.**
      
      이번에는 Gretty 플러그인을 사용하고 있지만, 이것은 Gradle 표준이 아니라 외부 라이브러리이다.
      따라서 빌드시 어떤 저장소에서 어떤 라이브러리를 사용할 것인지를 지정해야 한다. 그 부분이 buildsript에 있는 repositories과 dependencies이다. 이전에 이미 설명했던 내용이다.
      
      이 buildscript 이 후에 repositories과 dependencies이 있지만, 이것은 빌드 처리 이외의 곳에서 사용되는 것이다. 
      여기에서는 JUnit이 dependencies에 준비되어 있다.
- apply plugin
    - 앞서 선언한 플러그인 의존성들을 적용할 것인지를 결정하는 코드
- mavenCentral vs jcenter
    - 기본적으로 mavenCentral 를 많이 사용하지만 최근에 **라이브러리 업로드 난이도** 때문에 jcenter를 많이 이용한다.
    mavenCentral 은 이전 부터 많이 사용하는 저장소지만 본인이 만든 라이브러리를 업로드 하기 위해 **많은 과정과 설정**이 필요하다.
    그러다 보니 직접 만든 라이브러리를 업로드 하는 것이 힘들어 점점 공유가 안되는 상황이 발생했다.
    최근에 나온 jcenter은 그러한 **업로드를 간단하게 했다.**
    
    jcenter에 라이브러리를 업로드 하면 mavenCentral 에도 업로드될 수 있도록 자동화를 할 수 있다.
    
- dependencies 
    - 프로젝트 개발에 필요한 의존성들을 선언 하는 곳
    - 의존성 코드는 직접 장성해도 되고, 자동완성(`ctrl`+`space`) 으로 만들어도 좋지만,
    특정 버전을 명시하면 가장 처음에 작성했던 
    ```
    classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    ```
  의 버전을 따라가지 못한다.
  
 - intelliJ VCS 자동 add to git 설정 변경 방법
    - `Preferences | Version control | Confirmation | When files are created | Add silently.`
