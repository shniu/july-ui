import Settings from '../settings'
import Vue from 'vue'

export default {
  ok (res) {
    return res && res.data && res.data.code === Settings.responseCode.succeed
  },

  /**
   * 获取商务线列表
   * @returns {*[]}
   */
  getBizLines (uri, success, exp) {
    Vue.axios({
      method: 'get',
      url: uri,
      data: {}
    }).then(success).catch(exp)
  },

  /**
   * 增加商务线
   */
  addBizPipeline (data, success, exception) {
    console.debug('Action: 添加一条商务线, data: {}, backendUrl: {}', data, Settings.apiGateway.addBizLineUri)
    // Send request
    Vue.axios({
      method: 'post',
      url: Settings.apiGateway.addBizLineUri,
      data: data
    }).then(success).catch(exception)
    return true
  },

  /**
   * 删除商务线
   */
  deleteBizLine (bizId, success, exp) {
    Vue.axios({
      method: 'delete',
      url: Settings.apiGateway.deleteBizLineUri + '/' + bizId,
      data: {}
    }).then(success).catch(exp)
  },

  /**
   * 添加todo
   */
  addTodo (data, success, exp) {
    Vue.axios({
      method: 'post',
      url: Settings.apiGateway.addTodoUri,
      data: data
    }).then(success).catch(exp)
  },

  getTodos (bizId, success, exp) {
    let compiled = Vue.lodash.template(Settings.apiGateway.getTodosUri)
    const uri = compiled({bizId: bizId})
    Vue.axios({
      method: 'get',
      url: uri
    }).then(success).catch(exp)
  },

  /**
   * 删除todo
   */
  deleteTodo (tid, success, exp) {
    let compiled = Vue.lodash.template(Settings.apiGateway.deleteTodoUri)
    const uri = compiled({tid: tid})
    Vue.axios({
      method: 'delete',
      url: uri
    }).then(success).catch(exp)
  },

  /**
   * 改变todo状态
   */
  toggleTodo (data, success, exp) {
    Vue.axios({
      method: 'put',
      url: Settings.apiGateway.toggleTodoStatusUri,
      data: data
    }).then(success).catch(exp)
  }
}
