"use strict"
var adm = adm || {}
adm =(()=>{
   let _,js,css,img,navi_js,navi_vue_js
   
   let init=()=>{
        _=$.ctx()
         js=$.js()
         css=$.css()
         img=$.img()
         navi_js = js+'/cmm/navi.js'
         navi_vue_js = js+'/vue/navi_vue.js'
         
   }
   let onCreate=()=>{
      init()
      $.when(
            $.getScript(navi_js),
            $.getScript(navi_vue_js)
      ).done(()=>{
         setContentView()
      }).fail(()=>{
         alert('에러')
      })
   }
   let setContentView=()=>{
      
      $('body').html(navi_vue.navi())
      navi.onCreate()
      
      $('<table id="tab">'+
         '  <tr>'+
         '  </tr>'+
         '</table>')
      .css({border: '1px solid black',width: '80%', height:'80%', margin:'0 auto'})
      .appendTo('body')
      
      $.each(
            [{id:'left',width:'20%'},
            {id:'right',width:'80%'}],
            (i,j)=>{
            $('<td id="'+j.id+'"></td>')
            .css({border: '1px solid black',width: j.width, 'vertical-align':'top'})
            .appendTo('#tab tr')
         }
      )
      $.each(
            [{txt:'고객관리',name:'cust_mgmt'},
            {txt:'구장등록',name:'stad_reg'},
            {txt:'웹크롤링',name:'web_crawl'},
            {txt:'구장관리',name:'stad_mgmt'},
            {txt:'수익구조',name:'data_graph'},
            {txt:'게시판관리',name:'brd_mgmt'}],
         (i,j)=>{
         $('<div name="'+j.name+'">'+j.txt+'</div>')
         .css({border: '1px solid #ddd', margin: 'auto 0', 'line-height': '50px'})
         .appendTo('#left')
         .click(function(){
            $(this).addClass('active')
            $(this).siblings().removeClass('active')
            switch ($(this).attr('name')) {
            case 'cust_mgmt':
               $('#right').empty()
               //$('#right').append(cust_vue.cust())
               cust_mgmt();
               break;
            case 'stad_reg':
               $('#right').empty()
               break;
            case 'stad_mgmt':
               $('#right').empty()
               break;
            case 'data_graph':
               $('#right').empty()
               break;
            case 'web_crawl':
               $('#right').empty()
               webCrawl()
               break;
            case 'brd_mgmt':
               $('#right').empty()
               brd_mgmt()
               break;
            }
         })
      })
   }
   let webCrawl=()=>{
         
         $('</br></br></br><h2>Web Crawling</h2></br>'+
            '<form id="crawl_form">'+
            '  <select name="site" id="right2" size="1" >'+
            '  </select><br><br>'+
               '<input class="form-control mr-sm-2" type="text" placeholder="insert URL for crawling" aria-label="Search">'+
            '</form>'
         ).appendTo('#right')
         $('#crawl_form input[class="form-control mr-sm-2"]')
      .css({width:'80%'})
      $.each(
            [{sub:'naver.com'},
            {sub:'google.co.kr'},
            {sub:'daum.net'}],
            (i,j)=>{
         $('<option value="'+j.sub+'">'+j.sub+'</option>')
         .appendTo('#crawl_form select')
      })
      $('<button class="btn btn-secondary my-2 my-sm-0" type="submit">go crawl</button>')
      .appendTo('#crawl_form')
      .click(e=>{
         e.preventDefault()
         let arr = [$('#crawl_form select[name="site"]').val(),
                  $('#crawl_form input[type="text"]').val()]
         if(!$.fn.nullchecker(arr)){
         $.getJSON(_+'/tx/crawling/'+arr[0]+'/'+arr[1],d=>{
            alert(d.result)
            $('<h1>'+d.result+"</h1>").appendTo("#right")
         })
         }
      })
   }
   let cust_mgmt=()=>{
	   $('</br><br/><a> Database 생성</a>')
	   .appendTo('#right')
	   .click(e=>{
		   e.preventDefault()
		   $.getJSON(_+'/cmm/create/db',d=>{
			   alert('되냐?'+d.msg)
		   })
	   })
	   
	   /* $('</br><br/><a>고객 테이블 삭제</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/users/drop/table',d=>{
            alert('테이블 삭제? : '+d.msg)
         })
      })*/
	   
      $(' </br><br/><a> USER 테이블 생성 </a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/users/create/table',d=>{
            alert('테이블 생성? : '+d.msg)
         })
      })
      
       $('</br></br><a> FUTSAL 테이블 생성</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/fut/create/Futtab',d=>{
            alert("풋살테이블"+ d.msg)
         })
      })
      
      $('</br><a> FUTSAL 더미 생성</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/fut/create/FutDummy',d=>{
            alert("풋살더미"+ d.msg)
         })
      })
      
      $('</br></br><a>RES 테이블 생성</a>')
      .appendTo('#right').click(e=>{
         e.preventDefault()
         $.getJSON(_+'/reser/create/res',d=>{
            alert('테이블 생성 성공여부'+d.msg)
         })
      })
      
      $('</br></br><a>GAME 테이블 생성</a>')
      .appendTo('#right').click(e=>{
         e.preventDefault()
         $.getJSON(_+'/admins/create/game',d=>{
            alert('테이블 생성 성공여부'+d.msg)
         })
      })
      
      $('</br></br><a>LOL 테이블 생성</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/lols/create/lol',d=>{
            alert('lol테이블 생성'+d.msg)
         })
      })
      
      $('</br></br><a>REPORT 테이블 생성</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/reports/create/report',d=>{
            alert('report테이블 생성'+d.msg)
         })
      })
      
      $('</br></br><a>ADMIN 테이블 생성</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
            $.getJSON(_+'/admins/create/table',d=>{
         alert('관리자 테이블 생성: '+d.msg)
         })
      })
      
      $('</br></br><a>INCOME 테이블 생성</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
            $.getJSON(_+'/admins/create/revenue',d=>{
         alert('수익관리 테이블 생성: '+d.msg)
         })
      })
      $('</br></br><a>POST 테이블 생성</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/fut/create/Posttab',d=>{
            alert("포스트등록 "+ d.msg)
         })
      })
      
      $('</br></br><a>USER 더미 대량 입력</a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/tx/register/users',d=>{
            alert('일괄 등록된 유저의 수: '+d.msg)
         })
      })
      $('</br></br><a>POST 더미 대량 입력</a>')
      .appendTo('#right')
      .click(e=>{
    	  e.preventDefault()
    	  $.getJSON(_+'/tx/register/articles',d=>{
    		  alert('일괄 등록된 유저의 수: '+d.msg)
    	  })
      })
   }
   let brd_mgmt =()=>{
      $('<a>커뮤니티 테이블 생성<br/></a>')
      .appendTo('#right')
      .click(e=>{
         e.preventDefault()
         $.getJSON(_+'/articles/create/report',d=>{
            alert('report테이블 생성'+d.msg)
         })
      })
   }
   return{onCreate}
})()