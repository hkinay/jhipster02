import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IOgrenci } from 'app/shared/model/ogrenci.model';
import { getEntity, updateEntity, createEntity, reset } from './ogrenci.reducer';

export const OgrenciUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const ogrenciEntity = useAppSelector(state => state.ogrenci.entity);
  const loading = useAppSelector(state => state.ogrenci.loading);
  const updating = useAppSelector(state => state.ogrenci.updating);
  const updateSuccess = useAppSelector(state => state.ogrenci.updateSuccess);

  const handleClose = () => {
    navigate('/ogrenci');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    values.dogumTarihi = convertDateTimeToServer(values.dogumTarihi);

    const entity = {
      ...ogrenciEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          dogumTarihi: displayDefaultDateTime(),
        }
      : {
          ...ogrenciEntity,
          dogumTarihi: convertDateTimeFromServer(ogrenciEntity.dogumTarihi),
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="ex02App.ogrenci.home.createOrEditLabel" data-cy="OgrenciCreateUpdateHeading">
            <Translate contentKey="ex02App.ogrenci.home.createOrEditLabel">Create or edit a Ogrenci</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="ogrenci-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('ex02App.ogrenci.adiSoyadi')}
                id="ogrenci-adiSoyadi"
                name="adiSoyadi"
                data-cy="adiSoyadi"
                type="text"
              />
              <ValidatedField label={translate('ex02App.ogrenci.ogrNo')} id="ogrenci-ogrNo" name="ogrNo" data-cy="ogrNo" type="text" />
              <ValidatedField
                label={translate('ex02App.ogrenci.cinsiyeti')}
                id="ogrenci-cinsiyeti"
                name="cinsiyeti"
                data-cy="cinsiyeti"
                check
                type="checkbox"
              />
              <ValidatedField
                label={translate('ex02App.ogrenci.dogumTarihi')}
                id="ogrenci-dogumTarihi"
                name="dogumTarihi"
                data-cy="dogumTarihi"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
              />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/ogrenci" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default OgrenciUpdate;
