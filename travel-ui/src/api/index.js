import request from '@/utils/request'

export function getAllSpot(data){
  return request({
    url:'/getAllSpot',
    method: 'get',
    params: data
  })
}

export function test(){
  return request({
    url:'/test',
    method: 'get',
  })
}
