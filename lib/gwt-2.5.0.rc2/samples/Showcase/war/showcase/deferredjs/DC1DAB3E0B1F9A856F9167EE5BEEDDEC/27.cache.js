function Lib(a){this.a=a}
function Iib(a,b){this.a=a;this.b=b}
function kG(a,b){var c;c=EG((zG(),b));return lG(a,c,b,false)}
function Eib(a){var b,c,d;b=kdc(hr(a.a.cb,qvc));c=kdc(hr(a.b.cb,qvc));d=kdc(hr(a.c.cb,qvc));fRb(a.f,qyc+b+ryc+c+syc+d+trc);kRb(a.d,qyc+kG(a.e,b)+ryc+Y2(c)+syc+kG(a.e,d)+trc)}
function Dib(a){var b,c,d,e,f,g;d=new RTb;b=DH(d.j,99);d.o[xtc]=5;g=F3(IQ);e=new CMb(g);kj(e,new Iib(a,g),($w(),$w(),Zw));f=new HVb;f.e[xtc]=3;EVb(f,new oRb(lyc));EVb(f,e);LTb(d,0,0,f);$Tb(b,0)[pvc]=2;ITb(d,1,0,myc);ITb(d,1,1,"User {0} ({1} posts) added a comment on '{2}'");a.a=new oZb;eZb(a.a,(LD(),'\u05EA\u05D5\u05DE\u05E8 \u05D2\u05E8\u05D9\u05DF'));ITb(d,2,0,nyc);LTb(d,2,1,a.a);a.b=new oZb;eZb(a.b,'16');ITb(d,3,0,oyc);LTb(d,3,1,a.b);a.c=new oZb;eZb(a.c,'\u05DB\u05DE\u05D4 \u05D7\u05D5\u05DC \u05D9\u05E9 \u05D1\u05D7\u05D5\u05E3?');ITb(d,4,0,pyc);LTb(d,4,1,a.c);a.f=new mRb;ITb(d,5,0,'<b>Message formatted without BidiFormatter:<\/b>');LTb(d,5,1,a.f);dUb(b,5,0,(bVb(),aVb));a.d=new mRb;ITb(d,6,0,'<b>Message formatted with BidiFormatter:<\/b>');LTb(d,6,1,a.d);dUb(b,6,0,aVb);c=new Lib(a);kj(a.a,c,(Kx(),Kx(),Jx));kj(a.b,c,Jx);kj(a.c,c,Jx);Eib(a);return d}
var syc=" posts) added a comment on '",qyc='User ';o1(623,1,Enc,Iib);_.Dc=function Jib(a){y3(this.a,this.b+tyc)};_.a=null;_.b=null;o1(624,1,pnc,Lib);_.Fc=function Mib(a){Eib(this.a)};_.a=null;o1(625,1,Hnc);_.lc=function Qib(){Y3(this.b,Dib(this.a))};var IQ=Zbc(uuc,'BlogMessages'),LQ=Xbc(uuc,'CwBidiFormatting$1',623),MQ=Xbc(uuc,'CwBidiFormatting$2',624);uoc(wn)(27);