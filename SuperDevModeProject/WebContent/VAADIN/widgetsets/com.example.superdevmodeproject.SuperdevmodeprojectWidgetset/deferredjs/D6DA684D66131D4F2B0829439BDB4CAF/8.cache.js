$wnd.com_example_superdevmodeproject_SuperdevmodeprojectWidgetset.runAsyncCallback8("function UVb(a){return a.i}\nfunction WVb(a,b){_Ub(a,b);--a.j}\nfunction f1e(){Fb.call(this)}\nfunction $lf(){qc.call(this);this.x='v-colorpicker'}\nfunction jx(a){var b;b=a.c;if(b){return hx(a,b)}return KG(Vp(a.b))|0}\nfunction SQb(a,b,c,d){var e;sd(b);e=a.Jb.d;a.We(b,c,d);HQb(a,b,a.Qb,e,true)}\nfunction K7c(a,b){Agc(a.b,new cie(new tie(lEb),ePf),uG(DIb,lBf,0,[(Bpf(),b?Apf:zpf)]))}\nfunction VQb(){WQb.call(this,(SNb(),$doc.createElement(hEf)));aOb(this.Qb,DGf,MMf);aOb(this.Qb,RJf,lJf)}\nfunction ZVb(a,b){fVb.call(this);aVb(this,new CVb(this));dVb(this,new BWb(this));bVb(this,new wWb(this));XVb(this,b);YVb(this,a)}\nfunction VVb(a,b){if(b<0){throw new Uqf('Cannot access a row with a negative index: '+b)}if(b>=a.j){throw new Uqf(xJf+b+yJf+a.j)}}\nfunction YVb(a,b){if(a.j==b){return}if(b<0){throw new Uqf('Cannot set number of rows to '+b)}if(a.j<b){$Vb(a.D,b-a.j,a.i);a.j=b}else{while(a.j>b){WVb(a,a.j-1)}}}\nfunction UQb(a,b,c){var d;d=a.Qb;if(b==-1&&c==-1){YQb(d)}else{SNb();dr(d.style,DGf,GGf);dr(d.style,_If,b+hJf);dr(d.style,aJf,c+hJf)}}\nfunction vWb(a,b,c){var d,e;b=b>1?b:1;e=a.b.childNodes.length;if(e<b){for(d=e;d<b;++d){bp(a.b,$doc.createElement(CJf))}}else if(!c&&e>b){for(d=e;d>b;--d){gp(a.b,a.b.lastChild)}}}\nfunction $Vb(a,b,c){var d=$doc.createElement(uJf);d.innerHTML=qMf;var e=$doc.createElement(qJf);for(var f=0;f<c;f++){var g=d.cloneNode(true);e.appendChild(g)}a.appendChild(e);for(var i=1;i<b;i++){a.appendChild(e.cloneNode(true))}}\nfunction e1e(a){if((!a.B&&(a.B=T(a)),EG(EG(a.B,348),394)).e&&((!a.B&&(a.B=T(a)),EG(EG(a.B,348),394)).r==null||Srf(RDf,(!a.B&&(a.B=T(a)),EG(EG(a.B,348),394)).r))){return (!a.B&&(a.B=T(a)),EG(EG(a.B,348),394)).b}return (!a.B&&(a.B=T(a)),EG(EG(a.B,348),394)).r}\nfunction XVb(a,b){var c,d,e,f,g,i,j;if(a.i==b){return}if(b<0){throw new Uqf('Cannot set number of columns to '+b)}if(a.i>b){for(c=0;c<a.j;++c){for(d=a.i-1;d>=b;--d){PUb(a,c,d);e=RUb(a,c,d,false);f=zWb(a.D,c);SNb();f.removeChild(e)}}}else{for(c=0;c<a.j;++c){for(d=a.i;d<b;++d){g=zWb(a.D,c);i=(j=(SNb(),$doc.createElement(uJf)),SNb(),Ap(j,qMf),j);JPb(g,(bZb(),cZb(i)),d)}}}a.i=b;vWb(a.F,b,false)}\nvar o0f='background',j0f='com.vaadin.client.ui.colorpicker.',m0f='popupVisible',k0f='setColor',l0f='setOpen',n0f='showDefaultCaption';HJb(1,-1,cBf);_.gC=function O(){return this.cZ};HJb(12,13,{41:1,43:1,45:1,46:1,48:1,49:1,50:1,51:1,52:1,53:1,54:1,55:1,56:1,58:1,59:1,60:1,64:1,65:1,66:1,67:1,68:1,69:1,70:1,71:1,72:1,73:1,90:1,98:1,121:1,138:1,139:1,143:1,144:1,155:1,158:1,160:1,162:1});_.Vc=function Ld(a){return md(this,a,(lx(),lx(),kx))};HJb(458,459,_Bf,VQb);_.We=function $Qb(a,b,c){UQb(a,b,c)};HJb(467,14,{41:1,42:1,43:1,44:1,45:1,46:1,47:1,48:1,49:1,50:1,51:1,52:1,53:1,54:1,55:1,56:1,57:1,58:1,59:1,60:1,61:1,62:1,63:1,64:1,65:1,66:1,67:1,68:1,69:1,70:1,71:1,72:1,73:1,90:1,98:1,121:1,131:1,132:1,134:1,135:1,139:1,143:1,155:1,156:1,157:1,158:1,160:1,162:1});_.Vc=function xRb(a){return md(this,a,(lx(),lx(),kx))};HJb(486,460,gCf);_.Vc=function gVb(a){return md(this,a,(lx(),lx(),kx))};HJb(491,486,gCf,ZVb);_.mf=function _Vb(a){return UVb(this)};_.nf=function aWb(){return this.j};_.of=function bWb(a,b){VVb(this,a);if(b<0){throw new Uqf('Cannot access a column with a negative index: '+b)}if(b>=this.i){throw new Uqf(vJf+b+wJf+this.i)}};_.pf=function cWb(a){VVb(this,a)};_.i=0;_.j=0;HJb(502,14,{41:1,43:1,45:1,46:1,48:1,49:1,50:1,51:1,52:1,53:1,54:1,55:1,56:1,58:1,59:1,60:1,64:1,65:1,66:1,67:1,68:1,69:1,70:1,71:1,72:1,73:1,90:1,98:1,121:1,139:1,143:1,155:1,158:1,160:1,162:1});_.Vc=function cXb(a){return nd(this,a,(lx(),lx(),kx))};HJb(534,531,nCf);_.We=function k$b(a,b,c){b-=KG(0)|0;c-=KG(0)|0;UQb(a,b,c)};HJb(3279,4,qDf);_.ic=function g1e(){return false};_.lc=function h1e(){return !this.B&&(this.B=T(this)),EG(EG(this.B,348),394)};_.Zb=function i1e(){return !this.B&&(this.B=T(this)),EG(EG(this.B,348),394)};_._b=function j1e(){GG(this.nc(),48)&&EG(this.nc(),48).Vc(this)};_.bc=function k1e(a){yb(this,a);if(Fgc(a,eMf)){this.pi();(!this.B&&(this.B=T(this)),EG(EG(this.B,348),394)).e&&((!this.B&&(this.B=T(this)),EG(EG(this.B,348),394)).r==null||Srf(RDf,(!this.B&&(this.B=T(this)),EG(EG(this.B,348),394)).r))&&this.qi((!this.B&&(this.B=T(this)),EG(EG(this.B,348),394)).b)}(Fgc(a,UKf)||Fgc(a,hQf)||Fgc(a,n0f))&&this.qi(e1e(this))};HJb(3492,9,{348:1,361:1,394:1,464:1},$lf);_.b=null;_.c=false;_.d=false;_.e=false;var zAb=lqf(j0f,'AbstractColorPickerConnector',3279),mEb=lqf(r$f,'ColorPickerState',3492),wN=lqf(TYf,'Grid',491);GDf(Cm)(8);\n//@ sourceURL=8.js\n")
