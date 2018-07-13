import Settings from '../settings'
import Vue from 'vue'

export default {
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
  }
}
