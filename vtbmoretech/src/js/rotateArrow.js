function rotate (namePointer) {
    let name = document.querySelector("img[name="+namePointer+"]");
    let style = name.getAttribute ("style","transform rotate");

    let deg="";
    if (style!=null) {
        let l, r;
        for (let i=0; i<style.length; i++) {
            if (style[i] === "(") {l = i;}
            if (style[i] === "d") {r = i;}
        }
        
        for (let i=l+1; i<r; i++) {
            deg+=style[i];
        }

        deg = Number(deg);
        if (deg==0) {deg+=180;
        } else {deg-=180;} 
        
    } else {
        if ( (namePointer==="pointerSize")||(namePointer==="pointerType")||(namePointer==="pointerPost")) {
            deg=180
        } else {deg=0}
    }
    name.setAttribute ("style","transform: rotate(" + deg + "deg);");
}