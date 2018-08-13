var tooltips = {
  elements: document.getElementsByClassName('tooltips'),
  margins: function(){
    for (i=0;i<this.elements.length;i++){
      var tips = this.elements[i].getElementsByTagName('span');
      if (tips.length < 1) continue;
      var tip = tips[0]
      var width = tip.offsetWidth;
      var offset = width/2 > 1 ? Math.floor(width/2) : 1;
      tip.setAttribute('style', 'margin-left:-' + offset + 'px;');
    }
  },
  init: function () {this.margins();}
};

(function() {
  tooltips.init();
})();
