<template>
  <div>
    <el-container>
      <el-header class="july-header">
        <div class="wrap clearfix">
          <div class="title">
            <a href="#">July</a>
          </div>
          <div class="panel">
            <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
              <el-menu-item index="1">首页</el-menu-item>
              <el-menu-item index="2">登录</el-menu-item>
            </el-menu>
          </div>
        </div>
      </el-header>
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
                <el-input v-model="newLine.inChargeUser" placeholder="请输入负责人"></el-input>
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
                <el-form label-position="left" inline class="demo-table-expand">
                  <el-form-item label="商务线主题">
                    <span>{{ props.row.topic }}</span>
                  </el-form-item>
                  <el-form-item label="状态">
                    <span>{{ props.row.status }}</span>
                  </el-form-item>
                </el-form>
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
              :filters="[{ text: 'K1', value: 'K1' }, { text: 'K2', value: 'K2' }]"
              :filter-method="filterTag"
              filter-placement="bottom-end">
              <template slot-scope="scope">
                <el-tag
                  :type="scope.row.status === 'K1' ? 'primary' : 'success'"
                  disable-transitions>{{scope.row.status}}</el-tag>
              </template>
            </el-table-column>
            <el-table-column
              label="创建时间"
              prop="createdOn">
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
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
export default {
  name: 'Index',
  data () {
    return {
      activeIndex: '1',
      newLine: {
        topic: '',
        status: '',
        inChargeUser: ''
      },
      statusOptions: [{
        label: 'K1',
        value: 'K1'
      }, {
        label: 'K2',
        value: 'K2'
      }],
      bizLines: []
    }
  },
  mounted () {
    // 挂载成功后获取商务线列表
    this.bizLines = Backends.getBizLines()
  },
  methods: {
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
      console.log(index, row)
    },
    addPipeline () {
      // 构造请求post报文
      Backends.addBizPipeline(this.newLine, res => {
        console.log(res)
      }, res => {
        console.log(res)
      })
    }
  }
}
</script>

<style scoped lang="less">
  @import "~@/assets/less/variables";
  .july-header {
    width: 100%;
    background-color: #fff;
    -moz-box-shadow: 0 2px 4px -1px rgba(0,0,0,0.25);
    -webkit-box-shadow: 0 2px 4px -1px rgba(0,0,0,0.25);
    -o-box-shadow: 0 2px 4px -1px rgba(0,0,0,0.25);
    box-shadow: 0 2px 4px -1px rgba(0,0,0,0.25);
    /*position: fixed;*/
    padding: 0;

    .title {
      float: left;
      a {
        display: inline-block;
        margin-top: 10px;
        font-size: 28px;
        text-decoration: none;
        color: @logo-color;
      }
    }
    .panel {
      float: right;
    }
  }
</style>
