function CVb(){}
function GVb(){}
function vVb(a,b){a.b=b}
function wVb(a){if(a==lVb){return true}dE();return a==oVb}
function xVb(a){if(a==kVb){return true}dE();return a==jVb}
function EVb(a){this.b=(pXb(),kXb).a;this.d=(wXb(),vXb).a;this.a=a}
function yVb(){pVb();sPb.call(this);this.b=(pXb(),kXb);this.c=(wXb(),vXb);this.e[EGc]=0;this.e[FGc]=0}
function tVb(a,b){var c;c=XH(a.ab,98);c.b=b.a;!!c.c&&(c.c[CGc]=b.a,undefined)}
function uVb(a,b){var c;c=XH(a.ab,98);c.d=b.a;!!c.c&&YLb(c.c,DGc,b.a)}
function pVb(){pVb=Dpc;iVb=new CVb;lVb=new CVb;kVb=new CVb;jVb=new CVb;mVb=new CVb;nVb=new CVb;oVb=new CVb}
function qVb(a,b,c){var d;if(c==iVb){if(b==a.a){return}else if(a.a){throw new cfc(IZc)}}rj(b);t7b(a.j,b);c==iVb&&(a.a=b);d=new EVb(c);b.ab=d;tVb(b,a.b);uVb(b,a.c);sVb(a);tj(b,a)}
function rVb(a,b){var c,d,e,f,g,i,j;T6b(a.cb,fsc,b);i=new gnc;j=new E7b(a.j);while(j.a<j.b.c-1){c=C7b(j);g=XH(c.ab,98).a;e=XH(i.md(g),144);d=!e?1:e.a;f=g==mVb?JZc+d:g==nVb?KZc+d:g==oVb?LZc+d:g==jVb?MZc+d:g==lVb?NZc+d:g==kVb?OZc+d:nGc;T6b(ur(c.cb),b,f);i.od(g,rfc(d+1))}}
function sVb(a){var b,c,d,e,f,g,i,j,k,n,o,p,q,r,s,t;b=a.d;while(b.children.length>0){br(b,b.children[0])}q=1;e=1;for(i=new E7b(a.j);i.a<i.b.c-1;){d=C7b(i);f=XH(d.ab,98).a;f==mVb||f==nVb?++q:(f==jVb||f==oVb||f==lVb||f==kVb)&&++e}r=MH(E0,Jpc,99,q,0);for(g=0;g<q;++g){r[g]=new GVb;r[g].b=zr($doc,AGc);OLb(b,r[g].b)}k=0;n=e-1;o=0;s=q-1;c=null;for(i=new E7b(a.j);i.a<i.b.c-1;){d=C7b(i);j=XH(d.ab,98);t=zr($doc,BGc);j.c=t;j.c[CGc]=j.b;YLb(j.c,DGc,j.d);j.c[ntc]=fsc;j.c[ltc]=fsc;if(j.a==mVb){QLb(r[o].b,t,r[o].a);OLb(t,d.cb);t[QVc]=n-k+1;++o}else if(j.a==nVb){QLb(r[s].b,t,r[s].a);OLb(t,d.cb);t[QVc]=n-k+1;--s}else if(j.a==iVb){c=t}else if(wVb(j.a)){p=r[o];QLb(p.b,t,p.a++);OLb(t,d.cb);t[PZc]=s-o+1;++k}else if(xVb(j.a)){p=r[o];QLb(p.b,t,p.a);OLb(t,d.cb);t[PZc]=s-o+1;--n}}if(a.a){p=r[o];QLb(p.b,c,p.a);OLb(c,a.a.cb)}}
var QZc='DockPanel',TZc='DockPanel$DockLayoutConstant',UZc='DockPanel$LayoutData',RZc='DockPanel$TmpRow',SZc='DockPanel$TmpRow;',IZc='Only one CENTER widget may be added',EZc="This is a <code>ScrollPanel<\/code> contained at the center of a <code>DockPanel<\/code>.  By putting some fairly large contents in the middle and setting its size explicitly, it becomes a scrollable area within the page, but without requiring the use of an IFRAME.<br><br>Here's quite a bit more meaningless text that will serve primarily to make this thing scroll off the bottom of its visible area.  Otherwise, you might have to make it really, really small in order to see the nifty scroll bars!",AZc='This is the east component',yZc='This is the first north component',zZc='This is the first south component',CZc='This is the second north component',DZc='This is the second south component',BZc='This is the west component',xZc='cw-DockPanel',HZc='cwDockPanel',MZc='east',OZc='lineend',NZc='linestart',JZc='north',KZc='south',LZc='west';R1(725,1,yqc);_.mc=function tqb(){var a,b,c;Y4(this.a,(a=new yVb,a.cb[mtc]=xZc,a.e[EGc]=4,vVb(a,(pXb(),jXb)),qVb(a,new GTb(yZc),(pVb(),mVb)),qVb(a,new GTb(zZc),nVb),qVb(a,new GTb(AZc),jVb),qVb(a,new GTb(BZc),oVb),qVb(a,new GTb(CZc),mVb),qVb(a,new GTb(DZc),nVb),b=new GTb(EZc),c=new zQb(b),c.cb.style[ntc]=FZc,c.cb.style[ltc]=GZc,qVb(a,c,iVb),rVb(a,HZc),a))};R1(1029,985,Npc,yVb);_.Eb=function zVb(a){rVb(this,a)};_.Xb=function AVb(a){var b;b=hOb(this,a);if(b){a==this.a&&(this.a=null);sVb(this)}return b};_.a=null;var iVb,jVb,kVb,lVb,mVb,nVb,oVb;R1(1030,1,{},CVb);R1(1031,1,{98:1},EVb);_.a=null;_.c=null;R1(1032,1,{99:1},GVb);_.a=0;_.b=null;var UW=Nec(DJc,QZc,1029),TW=Nec(DJc,RZc,1032),E0=Mec(RKc,SZc,1366,TW),RW=Nec(DJc,TZc,1030),SW=Nec(DJc,UZc,1031);krc(wn)(11);