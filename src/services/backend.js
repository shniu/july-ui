import Settings from '../settings'
import Vue from 'vue'

export default {
  /**
   * 获取商务线列表
   * @returns {*[]}
   */
  getBizLines () {
    console.log(Settings.apiGateway.addBizLine)
    return [{
      topic: '商务线8888888',
      status: 'K2',
      createdOn: '2018-08-08 12:12:12'
    }]
  },

  /**
   * 增加商务线
   */
  addBizPipeline (data, success, exception) {
    console.debug('Action: 添加一条商务线, data: {}, backendUrl: {}', data, Settings.apiGateway.addBizLine)
    // Send request
    Vue.axios({
      method: 'post',
      url: Settings.apiGateway.addBizLine,
      data: data
    }).then(success).catch(exception)
    return true
  }
}
