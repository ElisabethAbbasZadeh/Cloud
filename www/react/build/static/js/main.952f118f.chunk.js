(this["webpackJsonpcloud-fb-react"]=this["webpackJsonpcloud-fb-react"]||[]).push([[0],{15:function(e,t,a){e.exports=a(26)},20:function(e,t,a){},21:function(e,t,a){},26:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),o=a(9),i=a.n(o),s=(a(20),a(10)),c=a(11),l=a(13),u=a(12),h=a(14),p=(a(21),function(e){var t=e.livresRes;return r.a.createElement("div",{className:"liste-livres"},t.map((function(e){return r.a.createElement("div",{key:e.path},e.title)})))}),m=a(2),v=function(e){var t=[];return fetch("https://cors-anywhere.herokuapp.com/https://cryptic-wave-17635.herokuapp.com/searchbooks?search="+e).then((function(e){return e.json()})).then((function(e){t=e.books}),(function(e){})),t},f=(a(22),function(e){function t(){var e;Object(s.a)(this,t),(e=Object(l.a)(this,Object(u.a)(t).call(this))).submitQuery=function(t){t.preventDefault();var a=v(e.state.value);e.setState({livresRes:a},(function(){console.log(this.state.livresRes," App")}))};var a={apiKey:"AIzaSyB-OG_3lnqcdChpwD42uKvYWMHGZWlc4Ow",authDomain:"daar-a1ea7.firebaseapp.com",databaseURL:"https://daar-a1ea7.firebaseio.com",projectId:"daar-a1ea7",storageBucket:"daar-a1ea7.appspot.com",messagingSenderId:"653755445186",appId:"1:653755445186:web:be24541935e8161d02b05b",measurementId:"G-BGZWWNYW0E"};try{m.initializeApp(a),m.analytics()}catch(n){console.log(n)}return e.state={firebaseConfig:a,db:m.firestore(),livresRes:[],value:""},e}return Object(h.a)(t,e),Object(c.a)(t,[{key:"handleChange",value:function(e){console.log(this.state.value),this.setState({value:e.target.value})}},{key:"render",value:function(){var e=this;return r.a.createElement("div",{className:"App"},r.a.createElement("h1",null,"Biblioth\xe8que en ligne"),r.a.createElement("form",{role:"search",onSubmit:function(t){return e.submitQuery(t)}},r.a.createElement("input",{type:"text",title:"Recherche par mots-cl\xe9s",id:"rechercher",value:this.state.value,onChange:function(t){return e.handleChange(t)},autoComplete:"off"})),r.a.createElement(p,{livresRes:this.state.livresRes}))}}]),t}(r.a.Component));Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));i.a.render(r.a.createElement(f,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[15,1,2]]]);
//# sourceMappingURL=main.952f118f.chunk.js.map