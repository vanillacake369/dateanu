# 서비스 소개
안동대 교내 데이트 매칭 앱입니다.
그룹을 지어 원하는 사람들과 과팅을 할 수 있으며
각 사용자 간에 매겨진 점수에 따라 1대1 미팅을 할 수 있습니다

# 요구사항

업데이트된 내용은 [해당 노션](https://www.notion.so/vanillacake369/b52315a6595146e28e7478fcb4a5f832?pvs=4)을 참고해주세요

> 아래는 23-06-10 요구사항

## 기능사항 칸반 보드 📋 “Abstract”

- 회원 정보
    - 입력 및 수정
    - 이름
    - 나이
    - 학과
    - 학번
    - 취미
        
        > 트위터처럼 각종 취미들을 나열해서 선택할 수 있게
        > 
    - 이성 취향
        
        > 트위터처럼 각종 취미들을 나열해서 선택할 수 있게
        > 
    - 프로필 사진
- 로그인
    - 교내 이메일 인증
- 회원가입
    - 교내 이메일 인증
    - 18세 이상만 회원가입할 수 있게 제한
        
        > 틴더 회원 정책임
        > 
- 회원 등급 부여
    - 소득
        
        > 학생이므로 이 부분은 X
        > 
    - 상대방이 본인에게 매칭하려고 시도한 횟수에 따라 평점
- 랜덤 매칭 정책
    - 등급에 따른 매칭 정책
    - 미팅이냐
    - 소개팅이냐
    - 새로고침 시 새로운 유저 리스팅
    - 사용자가 매칭 기준 선택
        - 나이 순
        - 취미 순
- 음성 통화 기능
- 영상 통화 기능
- 실시간 채팅 기능
    - 익명으로 방 입장 vs 본인 프로필로 입장
    - 안전번호 교환 기능
    - 만남약속장소 공유 기능
    - 거주기 공유 기능
    - 소개팅 매칭된 상대방과 1대1 매칭
    - 미팅 매칭된 상대방과 1대1 매칭
- 관리자 대시보드
    - 사용자 참여 수준 측정
    - 시간당 스와이프 횟수
    - 일일 매칭 횟수
    - 신규 사용자 수
- 보안 이슈
    - 개인정보 털리는 이슈
    - [Accidentally unmatched someone](https://www.help.tinder.com/hc/en-us/articles/115003517666-Problems-with-Matches#h_01G5S1WBKTK3D4G229BK4V1NZN)
    - [One or a few matches disappeared](https://www.help.tinder.com/hc/en-us/articles/115003517666-Problems-with-Matches#h_01G5S1WJ93K2SVJXFANETEGQE3)[](https://www.help.tinder.com/hc/en-us/articles/115003517666-Problems-with-Matches#h_01G5MBRMSXZWB6DR498C1PDRYG)
    - [All of my matches disappeared](https://www.help.tinder.com/hc/en-us/articles/115003517666-Problems-with-Matches#h_01G5S1WTWFRY31F5H610Z02YGZ)
    - [No new matches](https://www.help.tinder.com/hc/en-us/articles/115003517666-Problems-with-Matches#h_01G5S1X1WC8CRNQ85E3H2PPBHS)
    - [Matches loading indefinitely](https://www.help.tinder.com/hc/en-us/articles/115003517666-Problems-with-Matches#h_01G5S1X8KE0TR0TT04KJ8CFYQ3)
    - [My matches' photos won't load.](https://www.help.tinder.com/hc/en-us/articles/115003517666-Problems-with-Matches#h_01G5MCMF6PD52FPHE3269APAT8)

# 설계
[해당 노션](https://www.notion.so/vanillacake369/0919ccddc7f34883a0f8531e9146f00d?pvs=4)을 참고해주세요
