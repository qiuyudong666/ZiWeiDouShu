function gusid(len, radix) {
    var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
    var uuid = [], i;
    radix = radix || chars.length;
    if (len) {
        for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
    } else {
        var r;
        uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
        uuid[14] = '4';
        for (i = 0; i < 36; i++) {
            if (!uuid[i]) {
                r = 0 | Math.random() * 16;
                uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
            }
        }
    }
    return uuid.join('');
}
var routerUtils = {};

routerUtils.install = function(Vue) {
    Vue.prototype.$addSearchParams = function (options) {
        this.$store.dispatch('addSelect',options)
    }

    Vue.prototype.$getSearchParams = function (callback) {
        var name=callback.name
        console.log(name,this.$route.name)
        for(var i=0;i<callback.params.length;i++){
            var str=callback.params[i].field
            console.log(this.$store.getters.getselect[name])
            console.log(this.$store.getters.getselect[name].condition[str],"this.$store.getters.getselect[name].condition[str]")
            // if(this.$store.getters.getselect[name].condition[str].length==0||this.$store.getters.getselect[name].condition[str] !== ""){
                callback.params[i].value=this.$store.getters.getselect[name].condition[str]
            // }
        }
        return callback.params
    }
    Vue.prototype.$getPageNum = function (options) {
        if(this.$store.getters.getselect[options.name].page){
            return this.$store.getters.getselect[options.name].page.pageNum
        }else{
            return options.page.pageNum
        }

    }
    Vue.prototype.$getPageSize = function (options) {
        if(this.$store.getters.getselect[options.name].page){
            return this.$store.getters.getselect[options.name].page.pageSize
        }else{
            return options.page.pageSize
        }
    }
    Vue.prototype.$changePage = function (options) {
        this.$store.dispatch('changePage',options)
    }
    Vue.prototype.$getPage = function (options) {
        return this.$store.getters.getselect[options.name].page
    }
}

export default routerUtils;
