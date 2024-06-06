import request from '@/utils/request'

export function getAllHotel(data){
  return request({
    url:'/getAllHotel',
    method: 'get',
    params: data
  })
}

export function addHotel(data){
  return request({
    url:'/addHotel',
    method: 'post',
    data: data,
  })
}

export function updateHotel(data){
  return request({
    url:'/updateHotel',
    method: 'put',
    data: data,
  })
}

export function uploadImage(data){
  return request({
    url:'/upload',
    method: 'post',
    data: data,
  })
}
