<template>
  <div>
    <el-container>
      <july-header></july-header>
      <el-main class="july-main">
        <div class="wrap clearfix">
          <div style="margin: 30px 0 50px 0;">
            <el-row :gutter="10">
              <el-col :xs="24" :sm="6" :md="12" :lg="12" :xl="12">
                <el-input v-model="newLine.topic" placeholder="请输入商务线索,^_^"></el-input>
              </el-col>
              <el-col :xs="24" :sm="6" :md="4" :lg="4" :xl="4">
                <el-select v-model="newLine.status" placeholder="请选择状态">
                  <el-option
                    v-for="item in statusOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-col>
              <el-col :xs="24" :sm="6" :md="4" :lg="4" :xl="4">
                <!--<el-input v-model="newLine.inChargeUser" placeholder="请输入负责人"></el-input>-->
                <el-select v-model="newLine.inChargeUserId" placeholder="请选择负责人">
                  <el-option
                    v-for="item in inChargeUserOptions"
                    :key="item.uid"
                    :label="item.name"
                    :value="item.uid">
                  </el-option>
                </el-select>
              </el-col>
              <el-col :xs="24" :sm="6" :md="4" :lg="4" :xl="4" style="margin: 6px 0 0 0;padding-left: 10px;">
                <el-button type="primary" icon="el-icon-plus" size="small" @click="addPipeline">添加线索</el-button>
              </el-col>
            </el-row>
          </div>
          <h2>商务线索列表</h2>
          <el-table
            :data="bizLines"
            style="width: 100%">
            <el-table-column type="expand">
              <template slot-scope="props">
                <el-row :gutter="20">
                  <el-col :span="12">
                    <biz-progress v-bind:bizId="props.row.bizId"></biz-progress>
                  </el-col>
                  <el-col :span="12">
                    <todo v-bind:bizId="props.row.bizId"></todo>
                  </el-col>
                </el-row>
              </template>
            </el-table-column>
            <el-table-column
              label="主题"
              prop="topic">
            </el-table-column>
            <el-table-column
              prop="status"
              label="状态"
              width="100"
              :filters="statusOptions"
              :filter-method="filterTag"
              filter-placement="bottom-end">
              <template slot-scope="scope">
                <el-tag
                  :type="scope.row.status === 'K1' ? 'primary' : 'success'"
                  disable-transitions>{{scope.row.status}}</el-tag>
              </template>
            </el-table-column>
            <el-table-column
              label="负责人"
              prop="inChargeUser">
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <div class="load-more">
            <el-button type="text">加载更多</el-button>
          </div>
        </div>
      </el-main>
      <el-footer>
        <div class="july-footer">
          <div class="wrap">
            @Copyright by niushaohan & qianlimeng 2018
          </div>
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import Backends from '@/services/backend'
import Settings from '@/settings'
import JulyHeader from '@/components/header/Index'
import Todo from '@/components/todo/Index'
import BizProgress from '@/components/progress/Index'
export default {
  name: 'Index',
  components: {
    JulyHeader,
    BizProgress,
    Todo
  },
  data () {
    return {
      activeIndex: '1',
      newLine: {
        topic: '',
        status: '',
        inChargeUserId: ''
      },
      statusOptions: [{label: 'K1', value: 'K1', text: 'K1'}, {label: 'K2', value: 'K2', text: 'K2'}, {label: 'K3', value: 'K3', text: 'K3'},
        {label: 'K4', value: 'K4', text: 'K4'}, {label: 'K5', value: 'K5', text: 'K5'}, {label: 'K6', value: 'K6', text: 'K6'},
        {label: 'K7', value: 'K7', text: 'K7'}, {label: 'K8', value: 'K8', text: 'K8'}],
      bizLines: [],
      inChargeUserOptions: []
    }
  },
  mounted () {
    // 初始化负责人列表
    this.refreshInChargeUser()
    // 挂载成功后获取商务线列表
    this.refreshBizPipelines()
  },
  methods: {
    refreshInChargeUser () {
      Backends.queryInChargeUser(res => {
        if (Backends.ok(res)) {
          this.inChargeUserOptions = res.data.data
        } else {
          this.$message(res.data.msg)
        }
      }, res => {
        this.$message('获取负责人列表失败')
      })
    },
    refreshBizPipelines () {
      // todo pageable
      let uri = Settings.apiGateway.getBizLinesUri + '/0/10'
      Backends.getBizLines(uri, res => {
        this.bizLines = res.data.data.lines
      }, res => {
        this.$message('获取列表数据失败')
      })
    },
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    },
    filterTag (value, row) {
      return row.status === value
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      const bizId = row.bizId
      Backends.deleteBizLine(bizId, res => {
        this.$message('删除成功')
        this.refreshBizPipelines()
      }, res => {
        this.$message('删除失败')
      })
    },
    addPipeline () {
      // 构造请求post报文
      Backends.addBizPipeline(this.newLine, res => {
        console.log(res)
        this.$message('添加线索成功')
        // 清空输入
        this.newLine = {
          topic: '',
          status: '',
          inChargeUserId: ''
        }
        this.refreshBizPipelines()
      }, res => {
        console.log(res)
        this.$message('添加线索失败')
      })
    }
  }
}
</script>

<style scoped lang="less">
</style>
