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
          <div style="margin-top: 20px;">
            <el-row :gutter="10">
              <el-col :xs="8" :sm="6" :md="12" :lg="12" :xl="1">
                <el-input v-model="newLine.topic" placeholder="请输入商务线索,^_^"></el-input>
              </el-col>
              <el-col :xs="4" :sm="6" :md="4" :lg="4" :xl="11">
                <el-select v-model="newLine.status" placeholder="请选择状态">
                  <el-option
                    v-for="item in statusOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-col>
              <el-col :xs="4" :sm="6" :md="4" :lg="4" :xl="11">
                <el-input v-model="newLine.inChargeUser" placeholder="请输入负责人"></el-input>
              </el-col>
              <el-col :xs="8" :sm="6" :md="4" :lg="4" :xl="1">
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
      bizLines: [{
        topic: '商务线8888888',
        status: 'K2',
        createdOn: '2018-08-08 12:12:12'
      }]
    }
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
      const h = this.$createElement
      this.$msgbox({
        title: '添加Pipeline',
        message: h('p', null, [
          h('span', null, '内容可以是 '),
          h('i', { style: 'color: teal' }, 'VNode')
        ]),
        showCancelButton: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        beforeClose: (action, instance, done) => {
          if (action === 'confirm') {
            instance.confirmButtonLoading = true
            instance.confirmButtonText = '执行中...'
            setTimeout(() => {
              done()
              setTimeout(() => {
                instance.confirmButtonLoading = false
              }, 300)
            }, 3000)
          } else {
            done()
          }
        }
      }).then(action => {
        this.$message({
          type: 'info',
          message: 'action: ' + action
        })
      }) // -- end
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
