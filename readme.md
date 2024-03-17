<h1 align="center">5조 프로젝트 👍</h1>

> [플레이 데이터] 데이터 엔지니어링 ___ 기


🎬[Demo 시연영상](https://www.youtube.com/watch?v=dhMrKTwNI8U&lc=UgzCJR3WxkvsckRyyO94AaABAg&ab_channel=%EB%94%B0%EB%9D%BC%ED%95%98%EB%A9%B4%EC%84%9C%EB%B0%B0%EC%9A%B0%EB%8A%94IT)   

----------

## ✨ 프로젝트 설명


```sh
📦main
 ┣ 📂java
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┗ 📂travelproject
 ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthProvider.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthUserDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AuthUserService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂base
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DateUtil.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂constant
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AuthenticationTypes.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂handler
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginAuthFailureHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginAuthSuccessHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoutAuthSuccesshandler.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LodgeController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MainController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MypageController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜PlanController.java
 ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂impl
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDao.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDto.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserEntity.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┣ 📂impl
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java
 ┃ ┃ ┃ ┃ ┗ 📜TravelprojectApplication.java
 ┗ 📂resources
 ┃ ┣ 📂static
 ┃ ┣ 📂templates
 ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┣ 📜boardMain.html
 ┃ ┃ ┃ ┣ 📜noticeForm.html
 ┃ ┃ ┃ ┗ 📜noticeView.html
 ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┣ 📜footer.html
 ┃ ┃ ┃ ┣ 📜header.html
 ┃ ┃ ┃ ┗ 📜sidebar.html
 ┃ ┃ ┣ 📂lodge
 ┃ ┃ ┃ ┗ 📜lodgeMain.html
 ┃ ┃ ┣ 📂login
 ┃ ┃ ┃ ┣ 📜findIdPage.html
 ┃ ┃ ┃ ┣ 📜findPw.html
 ┃ ┃ ┃ ┣ 📜joinPage.html
 ┃ ┃ ┃ ┣ 📜loginPage.html
 ┃ ┃ ┃ ┗ 📜userIdPage.html
 ┃ ┃ ┣ 📂plan
 ┃ ┃ ┃ ┗ 📜planMain.html
 ┃ ┃ ┣ 📂staff
 ┃ ┃ ┃ ┣ 📜admin1.html
 ┃ ┃ ┃ ┣ 📜manager1.html
 ┃ ┃ ┃ ┣ 📜mypage.html
 ┃ ┃ ┃ ┣ 📜secured.html
 ┃ ┃ ┃ ┣ 📜securedRoles.html
 ┃ ┃ ┃ ┗ 📜user.html
 ┃ ┃ ┣ 📂temp
 ┃ ┃ ┗ 📜index.html
 ┃ ┣ 📜application.yml
 ┃ ┣ 📜intro_1.jpg
 ┃ ┣ 📜intro_2.jpg
 ┃ ┗ 📜intro_3.jpg
```

----------

## 📌 프로젝트 목표

```sh
Centos 8, Mysql(InnoDB)를 이용하여 설계를 통한 ERD 작성 및 구현
대용량 트래픽을 고려한 서버 이중화
```

----------

## 🐧 프로젝트 구현

> ### 🏢 **ERD**

<div align="center">
  <img src="./readme/ERD.png" style="zoom:76%;" align="center"/>
</div>

----------

----------

## 🤼‍♂️팀원

Team Leader : 🐯**강재전**

Member : 🐶 **안현준**

Member : 🐺 **김서윤**

Member : 🐱 **조은별**

Member : 🦁 **유성민**

