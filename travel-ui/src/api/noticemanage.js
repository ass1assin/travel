import request from '@/utils/request'

export function getAllNotice(data){
  return request({
    url:'/getAllNotice',
    method: 'get',
    params: data
  })
}
export function addNotice(data){
  return request({
    url:'/addNotice',
    method: 'post',
    data: data,
  })
}

export function updateNotice(data){
  return request({
    url:'/updateNotice',
    method: 'put',
    data: data,
  })
}

