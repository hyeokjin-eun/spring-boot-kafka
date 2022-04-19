# Spring Boot + Kafka
Spring Boot 와 Kafka 를 연동해서 CQRS 이벤트 소싱 예제 프로젝트

⚠ 해당 프로젝트는 Branch 로 프로젝트를 관리합니다. Branch 가 프로젝트가 됩니다.

⚠ Branch 로 프로젝트를 관리하는 이유
1. 프로젝트를 마이크로 서비스로 관리하기 위해서 입니다.
2. 마이크로 서비스로 분리된 서비스를 하나의 Git 저장소를 통해 관리하기 위해서 입니다.
3. 각 프로젝트는 Docker 로 띄워서 실행할 예정이며 Docker Network 로 묶어 서로 통신하게 됩니다.
4. 프로젝트에 대한 설명과 Branch 는 아래의 표를 참조합니다.

| 프로젝트 명 | PORT | BRANCH |
|-----------|------|--------|
| User      | 8081 | user   |
