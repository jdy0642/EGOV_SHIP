package com.ship.web.pxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
>>>>>>> sjw
=======
>>>>>>> ljs
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.aop.TxMapper;
import com.ship.web.usr.User;
import com.ship.web.usr.UserMapper;
@Component("manager")
public class UserProxy extends Proxy{
	@Autowired UserMapper userMapper;
<<<<<<< HEAD
<<<<<<< HEAD
	
=======
	@Autowired TxMapper txMapper;
>>>>>>> sjw
=======
>>>>>>> ljs
	 private char[] charaters = {'a','b','c','d','e','f','g','h','i',
			   'j','k','l','m','n','o','p','q','r','s','t','u','v','w',
			   'x','y','z','0','1','2','3','4','5','6','7','8','9'};
	   private int mailLength = 6; 
	   
<<<<<<< HEAD
<<<<<<< HEAD
	   public String makeUname(){
=======
	   public String mName(){
	//   uid,upw, uname,  loc, tel, point, age, gender,
//	    email, score, mvp, win, hitmap, km, heart, author, lolName
>>>>>>> sjw
	       List<String> fName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
	                 "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
	                 "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
	                 "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
	                 "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
	             List<String> lName = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
	                 "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
	                 "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
	                 "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
	                 "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
	                 "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
	                 "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
	                 "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
	                 "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
	                 "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
	             Collections.shuffle(fName);
	             Collections.shuffle(lName);
	             String fullName = fName.get(0) + lName.get(0) + lName.get(1);
	             return fullName;
	           }
=======
>>>>>>> ljs
	   
	  
	   public String mAge () {
			return String.format("%02d", random(1, 100)); 
		}
		
		public String mGender () {
			return (random(10, 10))%2 == 0 ? "남" : "여"; 
		}
		
		public String mTel () {
			return String.format("%03d",random(1, 100))+"-"+String.format("%04d",random(1, 1000));
			//return Integer.parseInt(String.format("%07d",random(1, 10000000)));
		}
		
		public String mUpoint () {
			return String.format("%04d",random(1, 1000));
		}
		
		public String mScore () {
			return String.format("%03d",random(1, 100));
		}
		
		public String mMvp () {
			return String.format("%02d",random(1, 100));
		}
		
		public String mWin () {
			return String.format("%02d",random(1, 100));
		}
		public String mKm () {
			return String.format("%03d",random(3, 100));
		}
<<<<<<< HEAD
	   public int setCalendars(){
	        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        int iMinMonth = 1;
	        int iMaxMonth = 12;
	        int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
	        int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
	        int iUserBirthMonth = iRandomMonth;
	        int iUserBirthDay = iRandomDay;
	        return 0;
	      }
	// uid,upw, uname,  loc, tel, point, age, gender,
	// email, score, mvp, win, hitmap, km, heart, author, lolName
	   
	private String makeLolName() {
		return null;
	}
	private String makeScore() {
		return null;
	}
	private String makeLolname() {
		return null;
	}
	private String makeAuthor() {
		return null;
	}
	private String makeKm() {
		return null;
	}
	private String makeHitmap() {
		return null;
	}
	private String makeWin() {
		return null;
	}
	private String makeEmail() {
	    StringBuffer sb = new StringBuffer();

	    Random ran = new Random();

	    for( int i = 0 ; i < mailLength ; i++ ){

	        sb.append( charaters[ ran.nextInt( charaters.length ) ] );
	    }
	    return sb.toString()+"gmail.com";
	}
	private String makeGender() {
		return null;
	}
	private String makeAge() {
		return null;
	}
	private String makePoint() {
		return null;
	}
	private String makeTel() {
		return null;
	}
	private String makeHeart() {
		return null;
	}

<<<<<<< HEAD
=======
	private String makeUname() {
		List<String> fName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
                "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
                "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
                "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
                "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
            List<String> lName = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
                "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
                "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
                "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
                "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
                "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
                "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
                "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
                "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
                "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
            Collections.shuffle(fName);
            Collections.shuffle(lName);
            String fullName = fName.get(0) + lName.get(0) + lName.get(1);
            return fullName;
	}
>>>>>>> ljs
	private String makeUid() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		String name[] = 
				"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
=======
>>>>>>> sjw
		
		public String mAuthor () {
			return (random(10, 10))%2 == 0 ? "1" : "0"; 
		}
<<<<<<< HEAD
		
		public String mCalendars(){
			  int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			  int iMinMonth = 1;
		      int iMaxMonth = 12;
		      int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
		      int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
		      int iUserBirthMonth = iRandomMonth;
		      int iUserBirthDay = iRandomDay;
		      return iUserBirthMonth +"-"+ iUserBirthDay;
		      
		    }
		
		public String eng(int x) {
			String result = "";
			for(int i = 0; i< x; i++) result += (char)((int)(Math.random()*26)+97);
			return result;
		}
		
		public String mUid() {
			return eng(8);
		}
		
		public String mEMail() {
			String result = eng((int)random(1, 10))+"@";
			switch((int)random(1, 10)) {
			case 0 : result += "naver.com"; break;
			case 1 : result += "google.com"; break;
			case 2 : result += "daum.com"; break;
			case 3 : result += "dreamwiz.com"; break;
			case 4 : result += "yahoo.com"; break;
			case 5 : result += "oohoo.com"; break;
			case 6 : result += "fff.com"; break;
			case 7 : result += "yyy.com"; break;
			case 8 : result += "xxxx.com"; break;
			case 9 : result += "zzzzz.com"; break;
			default : break;
			}
			return result;
		}
		
		public List<String> makeLoc() {
			List<String> result = new ArrayList<>();
			String url = "https://map.naver.com/v5/api/search?caller=pcweb&query=풋살장&type=all&page=2&displayCount=100&lang=ko";
			try {
				Document rawData;
				rawData = Jsoup.connect(url).timeout(10*1000)
						.ignoreContentType(true)
						.get();
			String input = rawData.text(),ptnS=""; 
			int cut = 0;
			ptnS = "\"address\":\"(.*?)\"";
			cut = 10; 
			result = matching(input,ptnS,cut);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		/* private String makeLoc() {
			   	List<String> loc = Arrays.asList("서울, 경기, 충청");
			   	Collections.shuffle(loc);
				return loc.get(0);
			}*/
		 
		public List<String> matching(String input, String ptnS, int cut){
			List<String> x = new ArrayList<>();
			Pattern ptn = Pattern.compile(ptnS);
			Matcher matcher = ptn.matcher(input);
			while(matcher.find()){
				x.add(matcher.group().substring(cut).replace("\"","")); 
			}
			return x;
		}
		//uid, upw, uname, age, gender, loc, tel, email, 
		//upoint, score, mvp, win, hitmap, km, heart, author, lolname
		public User makeUser(String loc) {
			return new User(mUid(),"1",mName(),mAge(),mGender(),loc,mTel(),mEMail(),mUpoint(),mScore(),mMvp(),mWin(),"hit",mKm(),"심박",mAuthor(),"소환사");
		}
<<<<<<< HEAD
=======
>>>>>>> ljs
		return buffer.toString();
	}
	public User makeUser() {
	      return new User(makeUid(),"1", makeUname(),makeLoc(),makeGender(), makeTel(), makeAge(),
	    		  makeEmail(), makeScore(), makeWin(), makeHitmap(), makeKm(), makeHeart(),
	    		  makeHitmap(), makeAuthor(), makeLolName());
	   }
	@Transactional 
	   public void insertUsers() {
		   for(int i=0; i<500;i++) {
<<<<<<< HEAD
			   userMapper.insertUser(makeUser());
=======
	@Transactional 
	   public void insertUsers() {
			List<String> x = new ArrayList<>();
			x = makeLoc();
		   for(String y : x) {
			   txMapper.insertUser(makeUser(y));
			   System.out.println(makeUser(y));
>>>>>>> sjw
=======
			   
			   userMapper.insertUser(makeUser());
>>>>>>> ljs
		   }
	   }
	public void truncateUser() {
		
	}
	
}
