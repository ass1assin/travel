import request from '@/utils/request'

export function getAllNotice(data){
  return request({
    url:'/getAllNotice',
    method: 'get',
    params: data
  })
}
