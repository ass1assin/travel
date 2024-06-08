import request from '@/utils/request';

export function getAllSpot(data){
  return request({
    url:'/getAllSpot',
    method: 'get',
    params: data
  })
}

export function addSpot(data){
  return request({
    url:'/addSpot',
    method: 'post',
    data: data,
  })
}

export function updateSpot(data){
  return request({
    url:'/updateSpot',
    method: 'put',
    data: data,
  })
}

