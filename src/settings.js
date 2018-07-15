
const settings = {
  domain: {
    // domain: 'http://192.168.1.118:7099'
    domain: 'http://localhost:7099'
    // domain: 'http://192.168.100.166:7099'
  },
  apiGateway: {
    addBizLineUri: '/api/v1/pipeline/info',
    getBizLinesUri: '/api/v1/pipeline/list',
    deleteBizLineUri: '/api/v1/pipeline/info',
    addTodoUri: '/api/v1/todo',
    /* eslint-disable */
    getTodosUri: '/api/v1/${ bizId }/todo',
    /* eslint-disable */
    deleteTodoUri: '/api/v1/todo/${tid}',
    toggleTodoStatusUri: '/api/v1/todo'
  },
  responseCode: {
    succeed: 0
  }
}

export default settings
