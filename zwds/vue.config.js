const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false
})



const webpack = require('webpack')
module.exports = {
  chainWebpack: config => {
    //引入ProvidePlugin
    config.plugin("provide").use(webpack.ProvidePlugin, [{
      $: "jquery",
      jquery: "jquery",
      jQuery: "jquery",
      "window.jQuery": "jquery",
    }, ]);
  },
}

